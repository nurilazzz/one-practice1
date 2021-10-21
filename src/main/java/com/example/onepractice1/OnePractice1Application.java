package com.example.onepractice1;

import com.example.onepractice1.service.PostOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnePractice1Application {
    private static PostOfficeService postOfficeService;

    @Autowired
    public void setPostOfficeService(PostOfficeService postOfficeService){
        this.postOfficeService = postOfficeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(OnePractice1Application.class, args);
        postOfficeService.getAllPosts().forEach(System.out::println);
    }

}
