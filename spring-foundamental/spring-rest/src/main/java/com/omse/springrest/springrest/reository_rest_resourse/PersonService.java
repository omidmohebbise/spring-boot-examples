package com.omse.springrest.springrest.reository_rest_resourse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements CommandLineRunner {
    private final PersonJpaRepository personJpaRepository;

    public PersonService(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }

    public List<Person> findAll(){
        return personJpaRepository.findAll();
    }

    public void add(){
        Person person = new Person();
        person.setName("Omid");
        person.setFamily("Mohebbi");
         personJpaRepository.save(person);
    }

    @Override
    public void run(String... args) {
        add();
        System.out.println(findAll());
    }
}
