package com.example.onepractice1.repository.impl;

import com.example.onepractice1.database.Client;
import com.example.onepractice1.repository.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {
    @Override
    public List<Client> findAll() {
        return Client.getClients();
    }

    @Override
    public Client findClientById(int id) {
        return Client.getClientById(id);
    }

    @Override
    public boolean saveClient(Client client) {
        return Client.saveClient(client);
    }

    @Override
    public void deleteClientById(int id) {
        Client.deleteClientById(id);
    }
}
