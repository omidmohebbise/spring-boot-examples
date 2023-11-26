package com.omidmohebbise.devazuredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DevAzureDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevAzureDemoApplication.class, args);
    }

    @GetMapping("/hello-world")
    public ResponseEntity<String> getHelloWorld(){
        return ResponseEntity.ok("Hello World");
    }

}
