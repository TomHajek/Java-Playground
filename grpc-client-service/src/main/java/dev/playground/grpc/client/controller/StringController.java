package dev.playground.grpc.client.controller;

import dev.playground.grpc.client.service.StringClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * To thest the endpoints, you can use BloomRPC, it is like a postman for RPC
 */
@RestController
@AllArgsConstructor
public class StringController {

    final StringClientService stringClientService;

    @GetMapping("/uppercase/{lowercase}")
    public ResponseEntity<String> getUpperCase(@PathVariable String lowercase) {
        return ResponseEntity.ok(stringClientService.getUpperCase(lowercase));
    }

}
