package dev.playground.feignclient;

import dev.playground.model.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ADDRESS-SERVICE", path = "/address-service/api")
public interface AddressClient { // proxy class

    @GetMapping("/address/{employeeId}")
    ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int id);

    @GetMapping("/address")
    ResponseEntity<List<AddressResponse>> getAllAddress();

}
