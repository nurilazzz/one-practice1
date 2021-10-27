package com.example.onepractice1.repository.impl;

import com.example.onepractice1.database.ClientDAO;
import com.example.onepractice1.models.Client;
import com.example.onepractice1.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {
    private ClientDAO clientDAO;

    @Autowired
    public ClientRepositoryImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public List<Client> findAll() {
        return clientDAO.findAll();
    }

    @Override
    public Client findClientById(Long id) {
        return clientDAO.findClientById(id);
    }

    @Override
    public void saveClient(Client client) {
        clientDAO.saveClient(client);
    }

    @Override
    public boolean deleteClientById(Long id) {
        return clientDAO.deleteClientById(id);
    }
}
