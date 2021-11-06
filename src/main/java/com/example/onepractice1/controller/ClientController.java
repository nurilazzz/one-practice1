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

        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Client savedClient = clientService.saveClient(client);

        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @PutMapping("/{client_id}")
    public ResponseEntity<Client> updateClient(@PathVariable(name = "client_id") Long clientId,
                                               @RequestBody Client client) {
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Client updatedClient = clientService.saveClient(client);

        return new ResponseEntity<>(updatedClient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{client_id}")
    public ResponseEntity<Client> deleteClientById(@PathVariable(name = "client_id") Long clientId) {
        Client client = clientService.getClientById(clientId);

        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        clientService.deleteClientById(clientId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clientsList = clientService.getAllClients();

        if (clientsList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(clientsList, HttpStatus.OK);
    }

    @PostMapping(value = "{client_id}/post/{post_id}/add")
    public ResponseEntity<Client> addPostToClient(@PathVariable(name = "client_id") Long clientId,
                                                  @PathVariable(name = "post_id") Long postId) {
        Client client = clientService.addClientToPost(clientId, postId);

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping(value = "{client_id}/address/{address_id}/add")
    public ResponseEntity<Client> addAddressToClient(@PathVariable(name = "client_id") Long clientId,
                                                  @PathVariable(name = "address_id") Long addressId) {
        Client client = clientService.addClientToAddress(clientId, addressId);

        return new ResponseEntity<>(client, HttpStatus.OK);
    }
}
