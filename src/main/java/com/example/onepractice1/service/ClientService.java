package com.example.onepractice1.service;

import com.example.onepractice1.models.Client;
import java.util.List;

public interface ClientService {
    List<Client> getAllClients();

    Client getClientById(Long id);

    Client saveClient(Client client);

    void deleteClientById(Long id);
}
