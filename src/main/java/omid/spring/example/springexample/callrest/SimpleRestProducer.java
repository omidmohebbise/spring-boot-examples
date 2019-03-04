package omid.spring.example.springexample.callrest;


import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SimpleRestProducer {

    @RequestMapping("/getperson")
    public Person getPerson() {
        Person person = new Person();
        person.setName("name");
        person.setFamily("family");
        return person;
    }


    @RequestMapping("/getpersons")
    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setName("name" + i);
            person.setFamily("family" + i);
            persons.add(person);
        }
        return persons;
    }


}
