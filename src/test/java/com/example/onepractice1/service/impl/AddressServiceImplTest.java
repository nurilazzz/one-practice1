package com.example.onepractice1.service.impl;

import com.example.onepractice1.models.Address;
import com.example.onepractice1.repository.AddressRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class AddressServiceImplTest {
    @Mock
    AddressRepository addressRepository;
    @InjectMocks
    AddressServiceImpl sut;

    private Address address;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        address = new Address(1L,"KZ","Shymkent",2);
    }

    @Test
    void testGetAllAddresses() {
        when(addressRepository.findAll()).thenReturn(List.of(address));
        List<Address> result  = sut.getAllAddresses();

        Assertions.assertEquals(List.of(address), result);
    }

    @Test
    void testGetAddressById() {

    }

    @Test
    void testSaveAddress() {

    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme