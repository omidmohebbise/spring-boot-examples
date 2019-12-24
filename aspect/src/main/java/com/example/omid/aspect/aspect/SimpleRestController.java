package com.example.omid.aspect.aspect;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {

    @GetMapping("/hi")
    public String printHelloWorld(){
        System.out.println("hello from controller");
        return "Hello World";
    }
}
