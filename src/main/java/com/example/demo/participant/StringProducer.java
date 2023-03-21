package com.example.demo.participant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StringProducer {

    @Value("${demo-kafka.topic}")
    String topic;

    @Autowired
    KafkaTemplate<String, String> template;

    public void send(String message) {
        template.send(topic, message);
    }

}
