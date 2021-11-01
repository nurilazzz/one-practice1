package com.example.onepractice1.kafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "random_topic", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Message received -> %s" + message);
    }

}
