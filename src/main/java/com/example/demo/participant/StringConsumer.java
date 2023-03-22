package com.example.demo.participant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StringConsumer {

    /**
     *  To use this, Change application.yml
     *
     *  value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
     *  value-serializer: org.apache.kafka.common.serialization.StringSerializer
     *
     *  And Add below code on consume(String message)
     *  code:
     *     @KafkaListener(topics = "${demo-kafka.topic.dca}", groupId = "${spring.kafka.consumer.group-id}")
     */
    public void consume(String message) {
        log.info("message: " + message);
    }

}
