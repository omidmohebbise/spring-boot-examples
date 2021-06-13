package com.spdeveloper.mockitostarter.persistence;

import com.spdeveloper.mockitostarter.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonPersistenceImpl implements PersonPersistence {

    private final PersonJpaRepository personJpaRepository;

    public PersonPersistenceImpl(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }

    @Override
    public Person save(Person person) {
        return personJpaRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
        return personJpaRepository.findAll();
    }

    @Override
    public Person findById(Long id) {
        return personJpaRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        personJpaRepository.deleteById(id);
    }
}
