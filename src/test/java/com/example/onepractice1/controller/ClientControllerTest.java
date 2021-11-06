package com.example.onepractice1.controller;

import com.example.onepractice1.models.Address;
import com.example.onepractice1.models.Client;
import com.example.onepractice1.models.Post;
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

class ClientControllerTest {
    @Mock
    ClientService clientService;
    @InjectMocks
    ClientController clientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetClient() {
        when(clientService.getClientById(anyLong())).thenReturn(new Client(Long.valueOf(1), "email", new Address(Long.valueOf(1), "landmark", "city", 0), Arrays.<Post>asList(new Post(Long.valueOf(1), "name", "description", "postStatus"))));

        ResponseEntity<Client> result = clientController.getClient(Long.valueOf(1));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testAddClient() {
        when(clientService.saveClient(any())).thenReturn(new Client(Long.valueOf(1), "email", new Address(Long.valueOf(1), "landmark", "city", 0), Arrays.<Post>asList(new Post(Long.valueOf(1), "name", "description", "postStatus"))));

        ResponseEntity<Client> result = clientController.addClient(new Client(Long.valueOf(1), "email", new Address(Long.valueOf(1), "landmark", "city", 0), Arrays.<Post>asList(new Post(Long.valueOf(1), "name", "description", "postStatus"))));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateClient() {
        when(clientService.saveClient(any())).thenReturn(new Client(Long.valueOf(1), "email", new Address(Long.valueOf(1), "landmark", "city", 0), Arrays.<Post>asList(new Post(Long.valueOf(1), "name", "description", "postStatus"))));

        ResponseEntity<Client> result = clientController.updateClient(Long.valueOf(1), new Client(Long.valueOf(1), "email", new Address(Long.valueOf(1), "landmark", "city", 0), Arrays.<Post>asList(new Post(Long.valueOf(1), "name", "description", "postStatus"))));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteClientById() {
        when(clientService.getClientById(anyLong())).thenReturn(new Client(Long.valueOf(1), "email", new Address(Long.valueOf(1), "landmark", "city", 0), Arrays.<Post>asList(new Post(Long.valueOf(1), "name", "description", "postStatus"))));

        ResponseEntity<Client> result = clientController.deleteClientById(Long.valueOf(1));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetAllClients() {
        when(clientService.getAllClients()).thenReturn(Arrays.<Client>asList(new Client(Long.valueOf(1), "email", new Address(Long.valueOf(1), "landmark", "city", 0), Arrays.<Post>asList(new Post(Long.valueOf(1), "name", "description", "postStatus")))));

        ResponseEntity<List<Client>> result = clientController.getAllClients();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testAddPostToClient() {
        when(clientService.addClientToPost(anyLong(), anyLong())).thenReturn(new Client(Long.valueOf(1), "email", new Address(Long.valueOf(1), "landmark", "city", 0), Arrays.<Post>asList(new Post(Long.valueOf(1), "name", "description", "postStatus"))));

        ResponseEntity<Client> result = clientController.addPostToClient(Long.valueOf(1), Long.valueOf(1));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testAddAddressToClient() {
        when(clientService.addClientToAddress(anyLong(), anyLong())).thenReturn(new Client(Long.valueOf(1), "email", new Address(Long.valueOf(1), "landmark", "city", 0), Arrays.<Post>asList(new Post(Long.valueOf(1), "name", "description", "postStatus"))));

        ResponseEntity<Client> result = clientController.addAddressToClient(Long.valueOf(1), Long.valueOf(1));
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme