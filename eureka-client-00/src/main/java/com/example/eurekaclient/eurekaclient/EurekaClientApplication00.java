package com.example.eurekaclient.eurekaclient;

import com.example.eurekaclient.eurekaclient.model.Person;
import javafx.scene.PerspectiveCamera;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@EnableEurekaClient
@SpringBootApplication
public class EurekaClientApplication00 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication00.class, args);
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
                person.setName("omid" + " " + i);
                person.setFamily("mohebbi" + " " + i);
                persons.add(person);
            }
            return persons;

        }
    }

}
