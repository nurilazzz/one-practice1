package com.example.onepractice1;

import com.example.onepractice1.models.Address;
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
        System.out.println("Good start!");

        Post post4 = new Post(4L, "Description", "SENT");
        Address address2 = new Address(2L,"KZ","ALA","Saina",12,21);
        postService.getAllPosts().forEach(System.out::println);
        System.out.println(postService.getPostById(1L));

        postService.deletePostById(1L);
        postService.savePost(post4);
        postService.getAllPosts().forEach(System.out::println);

        clientService.getAllClients().forEach(System.out::println);

        addressService.saveAddress(address2);
        addressService.getAllAddresses().forEach(System.out::println);
    }
}
