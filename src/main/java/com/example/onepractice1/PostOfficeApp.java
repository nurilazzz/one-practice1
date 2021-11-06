//package com.example.onepractice1;
//
//import com.example.onepractice1.models.Address;
//import com.example.onepractice1.models.Client;
//import com.example.onepractice1.models.Post;
//import com.example.onepractice1.service.AddressService;
//import com.example.onepractice1.service.ClientService;
//import com.example.onepractice1.service.PostService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class PostOfficeApp {
//
//    private static PostService postService;
//    private static ClientService clientService;
//    private static AddressService addressService;
//
//    @Autowired
//    public void setPostService(PostService postService) {
//        PostOfficeApp.postService = postService;
//    }
//
//    @Autowired
//    public void setClientService(ClientService clientService) {
//        PostOfficeApp.clientService = clientService;
//    }
//
//    @Autowired
//    public void setAddressService(AddressService addressService) {
//        PostOfficeApp.addressService = addressService;
//    }
//
//    public static void execute(){
//        System.out.println("Good start!");
//
//        Address address1 = new Address(1L,"KZ","ALA",12);
//        Address address2 = new Address(2L,"KZ","CIT",12);
//
//        Client client1 = new Client(1L,"n@gmail.com",address1);
//
//        clientService.saveClient(client1);
//
//        Post post1 = new Post(1L, "Name","Description", "SENT",client1);
//        Post post2 = new Post(2L,"Name", "Description", "DELIVERED",client1);
//
//        postService.savePost(post1);
//        postService.savePost(post2);
//
//        System.out.println(postService.getPostById(1L));
//
//        postService.getAllPosts().forEach(System.out::println);
//
//        clientService.getAllClients().forEach(System.out::println);
//
//        addressService.saveAddress(address1);
//        addressService.saveAddress(address2);
//        addressService.getAllAddresses().forEach(System.out::println);
//    }
//}
