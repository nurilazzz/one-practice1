package com.example.onepractice1.service;

import com.example.onepractice1.models.Address;
import com.example.onepractice1.models.Client;
import com.example.onepractice1.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public Address findAddressById(Long id){
        return addressRepository.findAddressById(id);
    }

    public void saveAddress(Address address){
        addressRepository.saveAddress(address);
    }

    public boolean deleteAddressById(Long id){
        return addressRepository.deleteAddressById(id);
    }
}
