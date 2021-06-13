package com.spdeveloper.mockitostarter.sample02;

import com.spdeveloper.mockitostarter.model.Person;
import com.spdeveloper.mockitostarter.persistence.PersonJpaRepository;
import com.spdeveloper.mockitostarter.persistence.PersonPersistence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
 import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class InjectMocksExample {

    @Mock
    PersonPersistence personPersistence;

    @InjectMocks
    PersonJpaRepository personJpaRepository;

    @Test
    void findById(){
        Person p = personPersistence.findById(1L);
    }

}
