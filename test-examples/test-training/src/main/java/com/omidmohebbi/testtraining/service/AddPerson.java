package com.omidmohebbi.testtraining.service;

import com.omidmohebbi.testtraining.entity.Person;
import com.omidmohebbi.testtraining.repository.PersonJpaRepository;
import com.omidmohebbi.testtraining.service.dto.PersonDto;
import org.springframework.stereotype.Service;

@Service
public class AddPerson {
    private PersonJpaRepository personJpaRepository;

    public AddPerson(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }

    public Long execute(PersonDto personDto){
        return personJpaRepository.save(Person.builder()
                .name(personDto.getName())
                .family(personDto.getFamily())
                .age(personDto.getAge())
                .build()).getId();
    }
}
