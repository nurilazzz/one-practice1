//package com.example.onepractice1.service.impl;
//
//import com.example.onepractice1.models.Address;
//import com.example.onepractice1.models.Client;
//import com.example.onepractice1.repository.AddressRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//
//class AddressServiceImplTest {
//    @Mock
//    AddressRepository addressRepository;
//    @InjectMocks
//    AddressServiceImpl sut;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void testGetAllAddresses() {
//        when(addressRepository.findAll()).thenReturn(Arrays.asList(new Address(1L, "KZ", "ALA", 12)));
//        List<Address> result = sut.getAllAddresses();
//
//        Assertions.assertEquals(Arrays.asList(new Address(1L, "KZ", "ALA", 12)), result);
//    }
//
//    @Test
//    void testSaveAddress() {
//        Address addressResult = new Address(1L, "KZ", "ALA", 12);
//        when(addressRepository.save(addressResult)).thenReturn(new Address(1L, "KZ", "ALA", 12));
//
//        Address result1 = sut.saveAddress(addressResult);
//
//        Assertions.assertEquals(new Address(1L, "KZ", "ALA", 12), result1);
//
//    }
//}