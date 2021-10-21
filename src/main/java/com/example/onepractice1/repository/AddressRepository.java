package com.example.onepractice1.repository;

import com.example.onepractice1.database.Address;

import java.util.List;

public interface AddressRepository {
    List<Address> findAll();
    Address findAddressById(int id);
    boolean saveAddress(Address address);
    void deleteAddressById(int id);
}
