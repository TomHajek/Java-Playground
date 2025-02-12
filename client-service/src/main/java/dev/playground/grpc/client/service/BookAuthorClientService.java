package dev.playground.grpc.client.service;

import com.google.protobuf.Descriptors;
import dev.playground.TempDB;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Service
public class BookAuthorClientService {

    @GrpcClient("grpc-server-service")
    BookAuthorServiceGrpc.BookAuthorServiceBlockingStub synchronousClient;

    @GrpcClient("grpc-server-service")
    BookAuthorServiceGrpc.BookAuthorServiceStub asynchronousClient;

    /**
     * unary - synchronous
     * the client will send one request, and the server will respond with one response
     */
    public Map<Descriptors.FieldDescriptor, Object> getAuthor(int authorId) {
        Author authorRequest = Author.newBuilder().setAuthorId(authorId).build();
        // making inter-service communication to grpc-service
        Author authorResponse = synchronousClient.getAuthor(authorRequest);
        return authorResponse.getAllFields();
    }

    /**
     * server streaming - asynchronous
     * the client will send one request, and server will send stream of response to the client
     */
    public List<Map<Descriptors.FieldDescriptor, Object>> getBooksByAuthor(int authorId) throws InterruptedException {
        final Author authorRequest = Author.newBuilder().setAuthorId(authorId).build();
        final List<Map<Descriptors.FieldDescriptor, Object>> response = new ArrayList<>();
        // since we are exposing resp api which should get response quickly, we are setting wait time for thread to complete
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        asynchronousClient.getBooksByAuthor(authorRequest, new StreamObserver<Book>() {
            @Override
            public void onNext(Book book) {
                response.add(book.getAllFields());
            }

            @Override
            public void onError(Throwable throwable) {
                countDownLatch.countDown();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        });
        boolean await = countDownLatch.await(1, TimeUnit.MINUTES);
        return await ? response : Collections.emptyList();
    }

    /**
     * client streaming - asynchronous
     * the client will stream of request, and the server will respond with one response
     */
    public Map<String, Map<Descriptors.FieldDescriptor, Object>> getExpensiveBook() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Map<String, Map<Descriptors.FieldDescriptor, Object>> response = new HashMap<>();
        StreamObserver<Book> responseObserver = asynchronousClient.getExpensiveBook(new StreamObserver<Book>() {
            @Override
            public void onNext(Book book) {
                response.put("Expensive Book", book.getAllFields());
            }

            @Override
            public void onError(Throwable throwable) {
                countDownLatch.countDown();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        });
        TempDB.getBooksFromTempDb().forEach(responseObserver::onNext);
        responseObserver.onCompleted();
        boolean await = countDownLatch.await(1, TimeUnit.MINUTES);
        return await ? response : Collections.emptyMap();
    }

    /**
     * bi-directional streaming
     * the client will send stream of request and server will respond with stream of response
     */
    public List<Map<Descriptors.FieldDescriptor, Object>> getBooksByGender(String gender) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final List<Map<Descriptors.FieldDescriptor, Object>> response = new ArrayList<>();
        StreamObserver<Book> responseObserver = asynchronousClient.getBooksByGender(new StreamObserver<Book>() {
            @Override
            public void onNext(Book book) {
                response.add(book.getAllFields());
            }

            @Override
            public void onError(Throwable throwable) {
                countDownLatch.countDown();
            }

            @Override
            public void onCompleted() {
                countDownLatch.countDown();
            }
        });
        TempDB.getAuthorsFromTempDb()
                .stream()
                .filter(author -> author.getGender().equalsIgnoreCase(gender))
                .forEach(author -> responseObserver.onNext(Book.newBuilder().setAuthorId(author.getAuthorId()).build()));
        responseObserver.onCompleted();
        boolean await = countDownLatch.await(1, TimeUnit.MINUTES);
        return await ? response : Collections.emptyList();
    }

}
