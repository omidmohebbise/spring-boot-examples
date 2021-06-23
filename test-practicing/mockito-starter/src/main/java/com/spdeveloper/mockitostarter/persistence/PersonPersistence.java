package com.spdeveloper.mockitostarter.persistence;

import com.spdeveloper.mockitostarter.model.Person;

import java.util.List;

public interface PersonPersistence {
    Person save(Person person);
    List<Person> findAll();
    Person findById(Long id);
    void deleteById(Long id);
    void delete(Person person);

}
