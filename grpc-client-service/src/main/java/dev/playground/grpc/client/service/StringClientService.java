package dev.playground.grpc.client.service;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StringClientService {

    @GrpcClient("grpc-service-channel")
    StringServiceGrpc.StringServiceBlockingStub client;

    public String getUpperCase(String lowerCase) {
        try {
            Response response = client.getUpperCaseString(Request.newBuilder().setLowerCase(lowerCase).build());
            return response.getUpperCase();
        } catch (Exception e) {
            log.error("error {}", e.getMessage());
        }
        return "";
    }

}