package com.example.onepractice1.kafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "quickstart-events", groupId = "groupId")
    public void consume(String message) {
        System.out.println("Message received -> %s" + message);
    }

}
