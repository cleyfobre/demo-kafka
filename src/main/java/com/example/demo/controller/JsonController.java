package com.example.demo.controller;

import com.example.demo.participant.JsonProducer;
import com.example.demo.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonController {

    @Autowired
    private JsonProducer producer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        producer.send(user);
        return ResponseEntity.ok("Message sent to the topic");
    }

}
