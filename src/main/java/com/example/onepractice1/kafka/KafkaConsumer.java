package com.example.onepractice1.kafka;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "nurila", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Message received -> %s" + message);
    }

}
