package dev.playground.grpc.client.controller;

import com.google.protobuf.Descriptors;
import dev.playground.grpc.client.service.BookAuthorClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class BookAuthorController {

    BookAuthorClientService bookAuthorClientService;

    /**
     * Here we are making API call to get author by id. It will go to client service
     * and make a remote procedure call (RPC) to another service (grpc-service) and
     * the logic to call the different service has been auto-generated in
     * `BookAuthorServiceGrpc.class`
     */
    @GetMapping("/author/{id}")
    public Map<Descriptors.FieldDescriptor, Object> getAuthor(@PathVariable String id) {
        return bookAuthorClientService.getAuthor(Integer.parseInt(id));
    }

    @GetMapping("/book/{author_id}")
    public List<Map<Descriptors.FieldDescriptor, Object>> getBookByAuthor(@PathVariable String author_id) throws InterruptedException {
        return bookAuthorClientService.getBooksByAuthor(Integer.parseInt(author_id));
    }

    @GetMapping("/book")
    public Map<String, Map<Descriptors.FieldDescriptor, Object>> getExpensiveBook() throws InterruptedException {
        return bookAuthorClientService.getExpensiveBook();
    }

    @GetMapping("/book/author/{gender}")
    public List<Map<Descriptors.FieldDescriptor, Object>> getBookByGender(@PathVariable String gender) throws InterruptedException {
        return bookAuthorClientService.getBooksByGender(gender);
    }

}
