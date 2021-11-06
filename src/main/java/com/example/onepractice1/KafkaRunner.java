package com.example.onepractice1;

import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.stereotype.Component;

//@Component
//public class KafkaRunner {
//    private static KafkaProducer kafkaProducer;
//
//    @Autowired
//    public KafkaRunner(KafkaProducer kafkaProducer) {
//        this.kafkaProducer = kafkaProducer;
//    }
//
//    public static void start(){
//        kafkaProducer.sendMessage("heelo");
//    }
//}
