package com.example.onepractice1.service.impl;

import com.example.onepractice1.models.Address;
import com.example.onepractice1.models.Client;
import com.example.onepractice1.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ClientServiceImplTest {
    @Mock
    ClientRepository clientRepository;
    @InjectMocks
    ClientServiceImpl clientServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllClients() {
        List<Client> result = clientServiceImpl.getAllClients();
        Assertions.assertEquals(Arrays.<Client>asList(new Client(Long.valueOf(1), "clientName", "surname", "email", new Address(Long.valueOf(1), "landmark", "city", "street", 0, 0))), result);
    }

    @Test
    void testGetClientById() {
        Client result = clientServiceImpl.getClientById(Long.valueOf(1));
        Assertions.assertEquals(new Client(Long.valueOf(1), "clientName", "surname", "email", new Address(Long.valueOf(1), "landmark", "city", "street", 0, 0)), result);
    }

    @Test
    void testSaveClient() {
        Client result = clientServiceImpl.saveClient(new Client(Long.valueOf(1), "clientName", "surname", "email", new Address(Long.valueOf(1), "landmark", "city", "street", 0, 0)));
        Assertions.assertEquals(new Client(Long.valueOf(1), "clientName", "surname", "email", new Address(Long.valueOf(1), "landmark", "city", "street", 0, 0)), result);
    }

    @Test
    void testDeleteClientById() {
        clientServiceImpl.deleteClientById(Long.valueOf(1));
    }
}

