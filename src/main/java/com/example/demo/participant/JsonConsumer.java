package com.example.demo.participant;

import com.example.demo.payload.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JsonConsumer {

    @KafkaListener(topics = "${demo-kafka.topic.dca}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user) {
        log.info("message: " + user);
    }

}
