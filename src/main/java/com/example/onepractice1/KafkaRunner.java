package com.example.onepractice1;

import com.example.onepractice1.kafka.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaRunner {
    private static KafkaProducer kafkaProducer;

    public void setKafkaProducer(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public static void start(){
        kafkaProducer.sendMessage(" ----- I am sending something fun ^_^ !!! ----- ");
    }
}
