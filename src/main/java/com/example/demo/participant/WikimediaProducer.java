package com.example.demo.participant;

import com.example.demo.handler.WikimediaHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class WikimediaProducer {

    @Autowired
    private WikimediaHandler handler;

    public void send() throws InterruptedException {
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource eventSource = new EventSource.Builder(handler, URI.create(url)).build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(5);
    }

}
