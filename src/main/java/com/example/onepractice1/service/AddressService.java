package com.example.onepractice1.service;

import com.example.onepractice1.models.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();

    Address getAddressById(Long id);

    Address saveAddress(Address address);
}
