package com.example.hystrix.hystrixserver;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimpleController {

    @Autowired
    public RestTemplate restTemplates;



    @HystrixCommand(fallbackMethod = "callFallBack")
    @RequestMapping("/helloworld")
    public String getHelloWorld(){

        String res = restTemplates.getForObject("http://localhost:9060/helloworld", String.class);
        return res + "=> from caller";
    }

    public String callFallBack(){
        return "he he he from fallbackMethod";
    }

    @Bean
    public RestTemplate getRestTemplates(){
        return new RestTemplate();
    }
}
