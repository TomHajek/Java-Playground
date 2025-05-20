package dev.playground.service;

import dev.playground.entity.Employee;
import dev.playground.feignclient.AddressClient;
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
    private final AddressClient addressClient;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper, AddressClient addressClient) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.addressClient = addressClient;
    }

    public EmployeeResponse getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);

        // instead of RestTemplate or WebClient, we are going to use FeignClient
        AddressResponse addressResponse = addressClient.getAddressByEmployeeId(id).getBody();

        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }

}
