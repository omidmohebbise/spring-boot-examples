package com.example.gatway.gatway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class GatwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatwayApplication.class, args);
    }
    @RestController
    public class SimpleController{
        @RequestMapping("/helloworld")
        public String getHelloworld(){
            return "hello world gateway";
        }
    }
}
