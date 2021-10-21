package com.example.onepractice1.service;

import com.example.onepractice1.database.Address;
import com.example.onepractice1.database.Client;
import com.example.onepractice1.database.Post;
import com.example.onepractice1.models.enumuration.PostStatus;
import com.example.onepractice1.repository.AddressRepository;
import com.example.onepractice1.repository.ClientRepository;
import com.example.onepractice1.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostOfficeService {
    private PostRepository postRepository;
    private ClientRepository clientRepository;
    private AddressRepository addressRepository;

    @Autowired
    public PostOfficeService(PostRepository postRepository, ClientRepository clientRepository,
                             AddressRepository addressRepository) {
        this.postRepository = postRepository;
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public boolean savePost(Post post){
        return postRepository.savePost(post);
    }

    public void deliveredPost(Post post){
        if(post != null && post.getStatus() == PostStatus.ON_THE_WAY) {
            post.setStatus(PostStatus.DELIVERED);
        }
    }

    public Post getPostById(int id){
        return postRepository.findPostById(id);
    }

    public void deletePostById(int id){
        postRepository.deletePostById(id);
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public boolean saveClient(Client client){
        return clientRepository.saveClient(client);
    }

    public Client getClientById(int id){
        return clientRepository.findClientById(id);
    }

    public void deleteClientById(int id){
        clientRepository.deleteClientById(id);
    }

    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }

    public boolean saveAddress(Address address){
        return addressRepository.saveAddress(address);
    }

    public Address getAddressById(int id){
        return addressRepository.findAddressById(id);
    }

    public void deleteAddressById(int id){
        addressRepository.deleteAddressById(id);
    }



}
