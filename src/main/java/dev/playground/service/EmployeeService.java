package dev.playground.service;

import dev.playground.entity.Employee;
import dev.playground.feignclient.AddressClient;
import dev.playground.model.AddressResponse;
import dev.playground.model.EmployeeResponse;
import dev.playground.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final AddressClient addressClient;
    private final DiscoveryClient discoveryClient;
    private final LoadBalancerClient loadBalancerClient;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper, AddressClient addressClient,
                           DiscoveryClient discoveryClient, LoadBalancerClient loadBalancerClient) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.addressClient = addressClient;
        this.discoveryClient = discoveryClient;
        this.loadBalancerClient = loadBalancerClient;
    }

    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeResponse> employeesResponse = Arrays.asList(modelMapper.map(employeeList, EmployeeResponse[].class));

        // rest call using open feign
        List<AddressResponse> addressResponse = addressClient.getAllAddress().getBody();

        // this is not efficient, it is O(n*m)
//        employeesResponse.forEach(employee -> {
//            for(AddressResponse address: addressResponse) {
//                if(address.getId() == employee.getId()) {
//                    employee.setAddressResponse(address);
//                }
//            }
//        });

        // convert the list of addresses to a map for O(1) lookups
        Map<Integer, AddressResponse> addressMap = addressResponse
                .stream()
                .collect(Collectors.toMap(AddressResponse::getId, Function.identity()));

        // match address to employee using the map
        employeesResponse.forEach(employee ->
                employee.setAddressResponse(addressMap.get(employee.getId()))
        );

        return employeesResponse;
    }

    public EmployeeResponse getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);

        /* For RestTemplate or WebClient approach */

        /*
        // getting details from discovery service
        List<ServiceInstance> instances = discoveryClient.getInstances("address-service");
        ServiceInstance serviceInstance = instances.get(0);
        String uri = serviceInstance.getUri().toString();
        */

        /*
        // using loadbalancer instead
        ServiceInstance serviceInstance = loadBalancerClient.choose("address-service");
        String uri = serviceInstance.getUri().toString();
        String contextPath = serviceInstance.getMetadata().get("configPath");

        System.out.println("uri >>> " + uri + contextPath);
        */

        /*
        // or we can use eureka directly with the name of the service
        // note that with this approach, we have to add @LoadBalanced to the RestTemplate or WebClient bean
        String path = "http://ADDRESS-SERVICE/address-service/api/address/{id}"
        */

        /* For FeignClient approach */
        // instead of RestTemplate or WebClient, we are going to use FeignClient
        // FeignClient/Eureka already have transient dependecy for the load balancing
        // by default it is using "round robbing" strategy
        AddressResponse addressResponse = addressClient.getAddressByEmployeeId(id).getBody();

        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }

}
