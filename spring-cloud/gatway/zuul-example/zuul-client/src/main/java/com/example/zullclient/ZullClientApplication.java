package com.example.zullclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ZullClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZullClientApplication.class, args);
    }

}
