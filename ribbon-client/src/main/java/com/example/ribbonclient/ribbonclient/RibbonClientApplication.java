package com.example.ribbonclient.ribbonclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@EnableEurekaClient
@SpringBootApplication
public class RibbonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonClientApplication.class, args);
    }
    @RestController
    public class Test {
        @RequestMapping("/helloworld")
        public String getHelloWorld() {
            Random random = new Random();
            int r = random.nextInt(5);
            return "Hello World(" + r + " )";

        }
    }
}




