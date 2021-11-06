package com.example.onepractice1.controller;

import com.example.onepractice1.models.Address;
import com.example.onepractice1.models.Client;
import com.example.onepractice1.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();

        if (addresses == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/{address_id}")
    public ResponseEntity<Address> getAddress(@PathVariable(name = "address_id") Long addressId) {
        Address address = addressService.getAddressById(addressId);

        if (address == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        if (address == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Address savedAddress = addressService.saveAddress(address);

        return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);
    }
}
