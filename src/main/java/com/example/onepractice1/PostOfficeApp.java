package com.example.onepractice1;

import com.example.onepractice1.models.Address;
import com.example.onepractice1.models.Client;
import com.example.onepractice1.models.Post;
import com.example.onepractice1.service.AddressService;
import com.example.onepractice1.service.ClientService;
import com.example.onepractice1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostOfficeApp {

    private static PostService postService;
    private static ClientService clientService;
    private static AddressService addressService;

    @Autowired
    public void setPostService(PostService postService) {
        PostOfficeApp.postService = postService;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        PostOfficeApp.clientService = clientService;
    }

    @Autowired
    public void setAddressService(AddressService addressService) {
        PostOfficeApp.addressService = addressService;
    }

    public static void execute(){

        Post post1 = new Post(1L,"Description","ON_THE_WAY");
        Post post2 = new Post(2L,"Description","ON_THE_WAY");

        Client client1 = new Client(1L,"Nurila","Zharkynbek","zharkynbeknurila@gmail.com");

        Address address1 = new Address(1L,"KZ","Shymkent","Mametov",2,11);

        postService.savePost(post1);
        postService.savePost(post2);
        postService.findAll().forEach(System.out::println);

        clientService.saveClient(client1);
        System.out.println(clientService.findClientById(1L));

        addressService.saveAddress(address1);
        addressService.findAll().forEach(System.out::println);

    }
}
