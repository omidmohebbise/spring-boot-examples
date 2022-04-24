package com.example.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController implements CommandLineRunner {

    @Autowired
    private SimpleBean simpleBean;

    @GetMapping("/hello")
    public String printHelloWorld(){
        return "Hello world";
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("call my repository");
    }
}
