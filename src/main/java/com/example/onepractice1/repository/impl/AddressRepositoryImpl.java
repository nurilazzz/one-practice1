package com.example.onepractice1.repository.impl;

import com.example.onepractice1.database.Address;
import com.example.onepractice1.repository.AddressRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

    @Override
    public List<Address> findAll() {
        return Address.getAddresses();
    }

    @Override
    public Address findAddressById(int id) {
        return Address.getAddressById(id);
    }

    @Override
    public boolean saveAddress(Address address) {
        return Address.saveAddress(address);
    }

    @Override
    public void deleteAddressById(int id) {
        Address.deleteAddressById(id);
    }
}
