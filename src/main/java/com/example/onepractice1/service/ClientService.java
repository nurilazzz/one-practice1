package com.example.onepractice1.service;

import com.example.onepractice1.models.Client;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();

    Client saveClient(Client client);
}
