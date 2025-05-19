package dev.playground.service;

import dev.playground.entity.Employee;
import dev.playground.model.AddressResponse;
import dev.playground.model.EmployeeResponse;
import dev.playground.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {

    @Value("${address-service.base.url}")
    private String addressBaseUrl;

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper, RestTemplate restTemplate) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.restTemplate = restTemplate;
    }

    public EmployeeResponse getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);

        AddressResponse addressResponse = restTemplate.getForObject(
                addressBaseUrl + "/address/{id}", AddressResponse.class, id
        );
        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }

}
