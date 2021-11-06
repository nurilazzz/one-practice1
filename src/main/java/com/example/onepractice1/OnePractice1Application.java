package com.example.onepractice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class OnePractice1Application {

    public static void main(String[] args) {
        SpringApplication.run(OnePractice1Application.class, args);

//        PostOfficeApp.execute()
//        KafkaRunner.start();
    }

}
