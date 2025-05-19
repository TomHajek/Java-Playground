package dev.playground.service;

import dev.playground.entity.Employee;
import dev.playground.model.AddressResponse;
import dev.playground.model.EmployeeResponse;
import dev.playground.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    //private final RestTemplate restTemplate;
    private final WebClient webClient;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository,
                           ModelMapper modelMapper,
                           /*@Value("${address-service.base.url}") String addressBaseUrl,
                           RestTemplateBuilder builder,*/
                           WebClient webClient) {

        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        //this.restTemplate = builder
        //        .rootUri(addressBaseUrl)
        //        .build();
        this.webClient = webClient;
    }

    public EmployeeResponse getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);

        // async (non-blocking) call
        AddressResponse addressResponse = webClient
                .get()
                .uri("/address/" + id)
                .retrieve()
                .bodyToMono(AddressResponse.class)
                .block();

        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }

    // sync (blocking) call -> blocking thread
    //private AddressResponse callingAddressServiceUsingRestTemplate(int id) {
    //    return restTemplate.getForObject("/address/{id}", AddressResponse.class, id);
    //}

}
