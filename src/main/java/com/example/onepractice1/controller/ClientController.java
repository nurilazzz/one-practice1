package com.example.onepractice1.controller;

import com.example.onepractice1.models.Client;
import com.example.onepractice1.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{client_id}")
    public ResponseEntity<Client> getClient(@PathVariable(name = "client_id") Long clientId) {
        Client client = clientService.getClientById(clientId);

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client savedClient = clientService.saveClient(client);

        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clientsList = clientService.getAllClients();

        return new ResponseEntity<>(clientsList, HttpStatus.OK);
    }
}
