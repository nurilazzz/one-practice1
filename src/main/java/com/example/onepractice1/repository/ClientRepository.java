package com.example.onepractice1.repository;

import com.example.onepractice1.database.Client;

import java.util.List;

public interface ClientRepository {
    List<Client> findAll();
    Client findClientById(int id);
    boolean saveClient(Client client);
    void deleteClientById(int id);
}
