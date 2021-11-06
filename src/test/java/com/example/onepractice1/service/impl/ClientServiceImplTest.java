//package com.example.onepractice1.service.impl;
//
//import com.example.onepractice1.models.Address;
//import com.example.onepractice1.models.Client;
//import com.example.onepractice1.models.Post;
//import com.example.onepractice1.repository.AddressRepository;
//import com.example.onepractice1.repository.ClientRepository;
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
//class ClientServiceImplTest {
//    @Mock
//    ClientRepository clientRepository;
//    @Mock
//    AddressRepository addressRepository;
//
//    @InjectMocks
//    ClientServiceImpl sut;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void testGetAllClients() {
//        Address address = new Address(1L, "KZ", "ALA", 12);
//        addressRepository.save(address);
//
//        when(clientRepository.findAll()).thenReturn(Arrays.asList(new Client(1L, "nurila@gmail.com", address)));
//        List<Client> result = sut.getAllClients();
//
//        Assertions.assertEquals(Arrays.asList(new Client(1L, "nurila@gmail.com", address)), result);
//    }
//
//    @Test
//    void testSaveClient() {
//        Address address = new Address(1L, "KZ", "ALA", 12);
//        addressRepository.save(address);
//
//        Address addressResult = new Address(1L, "KZ", "ALA", 12);
//        addressRepository.save(address);
//
//        Client clientResult = new Client(1L,"nurila@gmail.com",addressResult);
//        when(clientRepository.save(clientResult)).thenReturn(new Client(1L, "nurila@gmail.com",address));
//
//        Client result1 = sut.saveClient(clientResult);
//
//        Assertions.assertEquals(new Client(1L,"nurila@gmail.com",address), result1);
//
//    }
//}

