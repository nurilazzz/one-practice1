package com.example.onepractice1.service.impl;

import com.example.onepractice1.models.Address;
import com.example.onepractice1.repository.AddressRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class AddressServiceImplTest {
    @Mock
    AddressRepository addressRepository;
    @InjectMocks
    AddressServiceImpl addressServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Address address1 = new Address(1L,"KZ","ALA","Saina",12,21);
        addressServiceImpl.saveAddress(address1);
    }

    @Test
    void testGetAllAddresses() {
        List<Address> result = addressServiceImpl.getAllAddresses();
        Assertions.assertEquals(Arrays.<Address>asList(new Address(Long.valueOf(1), "landmark", "city", "street", 0, 0)), result);
    }

    @Test
    void testGetAddressById() {
        Address result = addressServiceImpl.getAddressById(Long.valueOf(1));
        Assertions.assertEquals(new Address(Long.valueOf(1), "landmark", "city", "street", 0, 0), result);
    }

    @Test
    void testSaveAddress() {
        Address result = addressServiceImpl.saveAddress(new Address(Long.valueOf(1), "landmark", "city", "street", 0, 0));
        Assertions.assertEquals(new Address(Long.valueOf(1), "landmark", "city", "street", 0, 0), result);
    }

    @Test
    void testDeleteAddressById() {
        addressServiceImpl.deleteAddressById(Long.valueOf(1));
    }
}