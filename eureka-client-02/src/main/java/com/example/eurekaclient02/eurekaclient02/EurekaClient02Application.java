package com.example.eurekaclient02.eurekaclient02;

import com.example.eurekaclient02.eurekaclient02.model.Person;
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

import java.util.ArrayList;
import java.util.List;

@EnableEurekaClient
@SpringBootApplication
public class EurekaClient02Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient02Application.class, args);
    }
    @RestController
    public class SimpleController {
        @RequestMapping("/helloworld")
        public String getHelloWorld() {
            return "Hello Worldss";
        }


        @RequestMapping("/persons")
        public List<Person> getPersons() {

            List<Person> persons = new ArrayList<Person>();
            for (int i = 0; i < 20; i++) {
                Person person = new Person();
                person.setName("s2 omid" + " " + i );
                person.setFamily("s2 mohebbi" + " " + i );
                persons.add(person);
            }
            return persons;

        }
    }
}
