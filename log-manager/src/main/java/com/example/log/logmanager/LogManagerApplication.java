package com.example.log.logmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LogManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogManagerApplication.class, args);
    }

    @GetMapping("/test")
    public String simpleController(){
        return "Hello";
    }

}
