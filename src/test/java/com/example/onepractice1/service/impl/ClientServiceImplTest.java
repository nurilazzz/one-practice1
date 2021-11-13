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

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


class ClientServiceImplTest {
    @Mock
    ClientRepository clientRepository;
    @InjectMocks
    ClientServiceImpl sut;

    private Client client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        client = new Client(1L, "nurila@gmail.com",  new Address(1L,"KZ","Shymkent",2),null);
    }

    @Test
    void testGetAllClients() {
        when(clientRepository.findAll()).thenReturn(List.of(client));
        List<Client> result = sut.getAllClients();

        Assertions.assertEquals(List.of(client), result);
    }

    @Test
    void testGetClientById() {
        when(clientRepository.findById(anyLong())).thenReturn(Optional.of(client));

        Client result = sut.getClientById(1L);

        Assertions.assertEquals(client, result);
    }

    @Test
    void testSaveClient() {
        doReturn(client).when(clientRepository).save(any());

        Client result = sut.saveClient(client);

        Assertions.assertNotNull(result, "The saved post should not be null");
    }

    @Test
    void testDeleteClientById() {
        when(clientRepository.findById(client.getId())).thenReturn(Optional.of(client));

        sut.deleteClientById(client.getId());

        verify(clientRepository).deleteById(client.getId());
    }
}