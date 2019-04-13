package com.example.simpleservice.simpleservice;

import com.example.loadbalancing.loadbalancing.LoadbalancingApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class SimpleserviceApplication {

    public static void main(String[] args) {

        SpringApplication app1 = new SpringApplication(SimpleserviceApplication.class);
        app1.setDefaultProperties(Collections
                .singletonMap("server.port", "8084"));
        app1.run(args);

    }

}
