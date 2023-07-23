package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

import java.util.concurrent.ConcurrentLinkedQueue;

@RestController
@CrossOrigin
public class RestReactiveController {

    private ConcurrentLinkedQueue<String> persons = new ConcurrentLinkedQueue<>();

    @GetMapping(value = "/simple-test", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> simpleTest() {
        var result = Flux.fromIterable(persons);
        return result.delayElements(Duration.ofMillis(500));
    }


    @Scheduled(fixedRate = 2000)
    private void addPerson() {
        persons.add("F Name " + persons.size());
    }

    @Value("${testproperty}")
    private String testValue;

    @GetMapping(value = "/hello-world")
    public ResponseEntity getHelloWorld() {
        return ResponseEntity.ok(testValue);
    }
}
