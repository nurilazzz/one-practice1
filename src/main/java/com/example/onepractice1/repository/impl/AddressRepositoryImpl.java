package com.example.onepractice1.repository.impl;

import com.example.onepractice1.database.AddressDAO;
import com.example.onepractice1.models.Address;
import com.example.onepractice1.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepositoryImpl implements AddressRepository {
    private AddressDAO addressDAO;

    @Autowired
    public AddressRepositoryImpl(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @Override
    public List<Address> findAll() {
        return addressDAO.findAll();
    }

    @Override
    public Address findAddressById(Long id) {
        return addressDAO.findAddressById(id);
    }

    @Override
    public void saveAddress(Address address) {
        addressDAO.saveAddress(address);
    }

    @Override
    public boolean deleteAddressById(Long id) {
        return addressDAO.deleteAddressById(id);
    }
}
