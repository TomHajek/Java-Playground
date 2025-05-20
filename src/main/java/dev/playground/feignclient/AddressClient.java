package dev.playground.feignclient;

import dev.playground.model.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
                                       // we will use load balancer in future
@FeignClient(name = "address-service", url = "http://localhost:8082", path = "/address-service/api")
public interface AddressClient { // proxy class

    @GetMapping("/address/{id}")
    ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("id") int id);

    @GetMapping("/address")
    ResponseEntity<List<AddressResponse>> getAllAddress();

}
