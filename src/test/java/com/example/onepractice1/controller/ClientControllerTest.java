package com.example.onepractice1.controller;

import com.example.onepractice1.models.Address;
import com.example.onepractice1.models.Client;
import com.example.onepractice1.service.ClientService;
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
import static org.springframework.http.HttpStatus.CREATED;

class ClientControllerTest {
    @Mock
    ClientService clientService;
    @InjectMocks
    ClientController clientController;

    private Client client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        client = new Client(1L, "nurila@gmail.com",  new Address(1L,"KZ","Shymkent",2),null);
    }

    @Test
    void testAddClient() {
        when(clientService.saveClient(any())).thenReturn(client);

        ResponseEntity<Client> result = clientController.addClient(client);

        Assertions.assertEquals(CREATED, result.getStatusCode());
    }

    @Test
    void testGetAllClients() {
        when(clientService.getAllClients()).thenReturn(Arrays.<Client>asList(client));

        ResponseEntity<List<Client>> result = clientController.getAllClients();

        Assertions.assertEquals(ResponseEntity.ok(clientService.getAllClients()), result);
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme