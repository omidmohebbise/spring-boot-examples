package com.spdeveloper.cassandra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PeopleService implements CommandLineRunner {

    @Autowired
    CassandraJpa cassandraJpa;

    @Override
    public void run(String... args) {
        insertPersons(20);
    }

    @Transactional
    void insertPersons(int length) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Person p = new Person(UUID.randomUUID().toString(), "omid" + i, 10 + i);
            people.add(p);
        }
        cassandraJpa.deleteAll();
        cassandraJpa.saveAll(people);
        System.out.println(cassandraJpa.count() + " People registered. :)");
    }
}
