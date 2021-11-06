package com.example.onepractice1.controller;

import com.example.onepractice1.models.Address;
import com.example.onepractice1.service.AddressService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class AddressControllerTest {
    @Mock
    AddressService addressService;
    @InjectMocks
    AddressController addressController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllAddresses() {
        when(addressService.getAllAddresses()).thenReturn(Arrays.<Address>asList(new Address(Long.valueOf(1), "landmark", "city", 0)));

        ResponseEntity<List<Address>> result = addressController.getAllAddresses();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetAddress() {
        when(addressService.getAddressById(anyLong())).thenReturn(new Address(Long.valueOf(1), "landmark", "city", 0));

        ResponseEntity<Address> result = addressController.getAddress(Long.valueOf(1));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testAddAddress() {
        when(addressService.saveAddress(any())).thenReturn(new Address(Long.valueOf(1), "landmark", "city", 0));

        ResponseEntity<Address> result = addressController.addAddress(new Address(Long.valueOf(1), "landmark", "city", 0));
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme