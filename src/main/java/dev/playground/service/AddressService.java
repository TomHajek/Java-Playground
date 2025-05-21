package dev.playground.service;

import dev.playground.entity.Address;
import dev.playground.model.AddressResponse;
import dev.playground.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AddressService(AddressRepository addressRepository,  ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    public List<AddressResponse> getAllAddress() {
        List<Address> addresses = addressRepository.findAll();
        List<AddressResponse> response = Arrays.asList(modelMapper.map(addresses, AddressResponse[].class));
        return response;
    }

    public AddressResponse getEmployeeAddress(int employeeId) {
        Address address = addressRepository.findAddressByEmployeeId(employeeId);
        return modelMapper.map(address, AddressResponse.class);
    }

}
