package dev.playground.grpc.server.service;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@Slf4j
public class StringServerService extends StringServiceGrpc.StringServiceImplBase {

    public void getUpperCaseString(Request request, StreamObserver<Response> responseObserver) {
        log.info("getUpperCaseString {}", request);
        responseObserver.onNext(
                Response.newBuilder().setUpperCase(request.getLowerCase().toUpperCase()).build());
        responseObserver.onCompleted();
    }
}
