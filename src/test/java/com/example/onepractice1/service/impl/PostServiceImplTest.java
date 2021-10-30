package com.example.onepractice1.service.impl;

import com.example.onepractice1.models.Address;
import com.example.onepractice1.models.Client;
import com.example.onepractice1.models.Post;
import com.example.onepractice1.repository.AddressRepository;
import com.example.onepractice1.repository.ClientRepository;
import com.example.onepractice1.repository.PostRepository;
import javafx.geometry.Pos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

class PostServiceImplTest {
    @Mock
    PostRepository postRepository;

    @Mock
    ClientRepository clientRepository;

    @Mock
    AddressRepository addressRepository;

    @InjectMocks
    PostServiceImpl sut;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Address address = new Address(1L, "KZ", "ALA", "Saina", 12, 21);
        addressRepository.save(address);
        Client client = new Client(1L, "Nurila", "Zharkynbek", "n@gmail.com", address);
        clientRepository.save(client);
    }

    @Test
    void testGetAllPosts() {
        Address address = new Address(1L, "KZ", "ALA", "Saina", 12, 21);
        addressRepository.save(address);
        Client client = new Client(1L, "Nurila", "Zharkynbek", "n@gmail.com", address);
        clientRepository.save(client);

        when(postRepository.findAll()).thenReturn(Arrays.asList(new Post(1L, "Desc", "ON_THE_WAY", client)));
        List<Post> result = sut.getAllPosts();

        Assertions.assertEquals(Arrays.asList(new Post(1L, "Desc", "ON_THE_WAY", new Client(1L, "Nurila", "Zharkynbek", "n@gmail.com", new Address(1L, "KZ", "ALA", "Saina", 12, 21)))), result);
    }

    @Test
    void testGetPostById() {
        Address address = new Address(1L, "KZ", "ALA", "Saina", 12, 21);
        addressRepository.save(address);
        Client client = new Client(1L, "Nurila", "Zharkynbek", "n@gmail.com", address);
        clientRepository.save(client);

        when(postRepository.findById(1L)).thenReturn(java.util.Optional.of(new Post(1L, "Desc", "ON_THE_WAY", client)));
        Post result = sut.getPostById(1L);

        Assertions.assertEquals(new Post(1L, "Desc", "ON_THE_WAY", new Client(1L, "Nurila", "Zharkynbek", "n@gmail.com", new Address(1L, "KZ", "ALA", "Saina", 12, 21))), result);
    }

    @Test
    void testSavePost() {
        Address address = new Address(1L, "KZ", "ALA", "Saina", 12, 21);
        addressRepository.save(address);
        Client client = new Client(1L, "Nurila", "Zharkynbek", "n@gmail.com", address);
        clientRepository.save(client);

        Address addressResult = new Address(1L, "KZ", "ALA", "Saina", 12, 21);
        addressRepository.save(address);
        Client clientResult = new Client(1L, "Nurila", "Zharkynbek", "n@gmail.com", addressResult);
        clientRepository.save(client);

        Post result = new Post(1L,"Desc","SENT",clientResult);
        when(postRepository.save(result)).thenReturn(new Post(1L, "Desc", "ON_THE_WAY", client));

        Post result1 = sut.savePost(result);

        Assertions.assertEquals(new Post(1L, "Desc", "ON_THE_WAY", client), result1);

    }
}

