package com.example.circuitbreaker.circiutbreaker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    //@HystrixCommand(fallbackMethod = "doSomething")
    @RequestMapping("/hellowolrd")
    public String getHelloFromCircuitBreaker(){
        return "hello world";
    }

    /*public String doSomething(){
        System.out.println("################ doSomething called.");
        return "hello world from circuit breaker";
    }*/
}
