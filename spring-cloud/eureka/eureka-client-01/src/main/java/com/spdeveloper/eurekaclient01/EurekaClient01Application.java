package com.spdeveloper.eurekaclient01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@EnableEurekaClient
@SpringBootApplication
public class EurekaClient01Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient01Application.class, args);
    }

    @RestController
    public class SimpleController {
        @RequestMapping("/helloworld")
        public String getHelloWorld() {
            return "Hello World";
        }


    }


    @RestController
    public class SimpleControllerConsumer {

        @Autowired
        private DiscoveryClient discoveryClient;

        @LoadBalanced
        @Bean
        public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder){
            return restTemplateBuilder.build();
        }

        @Autowired
        private RestTemplate  restTemplate;


        @RequestMapping("/callperons")
        public List getPersons() {

            List<ServiceInstance> instances=discoveryClient.getInstances("EUREKA-CLIENT-00");
            int random = (new Random()).nextInt(10);

            ServiceInstance serviceInstance;
            if(random % 2 == 0)
            serviceInstance = instances.get(0);
            else
            serviceInstance = instances.get(1);

            String baseUrl=serviceInstance.getUri().toString();

            baseUrl=baseUrl+"/persons";
            System.out.println("baseUrl = " + baseUrl);
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(baseUrl, List.class);
        }


    }
}
