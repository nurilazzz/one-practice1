package com.example.onepractice1.service.impl;

import com.example.onepractice1.models.Client;
import com.example.onepractice1.repository.ClientRepository;
import com.example.onepractice1.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }


    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
}
