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

@Service
public class EmployeeService {

    // this would not work with RestTemplateBuilder because, when it is initialized, this value is not read yet
    //@Value("${address-service.base.url}")
    //private String addressBaseUrl;

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository,
                           ModelMapper modelMapper,
                           // we have to put it directly into the constructor to find the value when needed
                           @Value("${address-service.base.url}") String addressBaseUrl,
                           RestTemplateBuilder builder) {

        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.restTemplate = builder
                .rootUri(addressBaseUrl)
                .build();
    }

    public EmployeeResponse getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);

        AddressResponse addressResponse = restTemplate.getForObject(
                "/address/{id}", AddressResponse.class, id
        );
        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }

}
