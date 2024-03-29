package com.example.demo;

import com.example.demo.participant.WikimediaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WikimediaProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WikimediaProducerApplication.class);
    }

    @Autowired
    private WikimediaProducer producer;

    @Override
    public void run(String... args) throws Exception {
        producer.send();
    }
}
