package com.example.onepractice1.service;

import com.example.onepractice1.models.Client;
import com.example.onepractice1.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client findClientById(Long id){
        return clientRepository.findClientById(id);
    }

    public void saveClient(Client client){
        clientRepository.saveClient(client);
    }

    public boolean deleteClientById(Long id){
        return clientRepository.deleteClientById(id);
    }
}
