package com.example.onepractice1.controller;

import com.example.onepractice1.models.Address;
import com.example.onepractice1.service.AddressService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.CREATED;


class AddressControllerTest {
    @Mock
    AddressService addressService;

    @InjectMocks
    AddressController addressController;

    @Autowired
    MockMvc mockMvc;

    private Address address;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        address = new Address(1L, "KZ", "Shymkent", 2);
    }

    @Test
    void testGetAllAddresses() {
        when(addressService.getAllAddresses()).thenReturn(Arrays.<Address>asList(address));

        ResponseEntity<List<Address>> result = addressController.getAllAddresses();
        Assertions.assertEquals(ResponseEntity.ok(addressService.getAllAddresses()), result);
    }

    @Test
    void testAddAddress() {
        when(addressService.saveAddress(any())).thenReturn(address);

        ResponseEntity<Address> result = addressController.addAddress(address);

        Assertions.assertEquals(CREATED, result.getStatusCode());

    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme