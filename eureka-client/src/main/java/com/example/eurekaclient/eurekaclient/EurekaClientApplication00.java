package com.example.eurekaclient.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class EurekaClientApplication00 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication00.class, args);
    }

    @EnableEurekaClient
    @RestController
    public class SimpleController {
        @RequestMapping("/helloworld")
        public String getHelloWorld() {
            return "Hello World";
        }
    }

}
