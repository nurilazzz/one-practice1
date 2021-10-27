package com.example.onepractice1.database;

import com.example.onepractice1.models.Client;

import java.util.List;

public interface ClientDAO {
    List<Client> findAll();
    Client findClientById(Long id);
    void saveClient(Client client);
    boolean deleteClientById(Long id);
}
