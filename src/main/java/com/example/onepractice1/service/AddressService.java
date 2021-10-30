package com.example.onepractice1.service;

import com.example.onepractice1.models.Address;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();

    Address saveAddress(Address address);
}
