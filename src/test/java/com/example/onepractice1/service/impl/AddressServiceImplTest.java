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
    }

    @Test
    void testGetAllAddresses() {
        List<Address> result = addressServiceImpl.getAllAddresses();
        Assertions.assertEquals(Arrays.<Address>asList(new Address(Long.valueOf(1), "landmark", "city", 0)), result);
    }

    @Test
    void testGetAddressById() {
        Address result = addressServiceImpl.getAddressById(Long.valueOf(1));
        Assertions.assertEquals(new Address(Long.valueOf(1), "landmark", "city", 0), result);
    }

    @Test
    void testSaveAddress() {
        Address result = addressServiceImpl.saveAddress(new Address(Long.valueOf(1), "landmark", "city", 0));
        Assertions.assertEquals(new Address(Long.valueOf(1), "landmark", "city", 0), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme