package com.spdeveloper.mockitostarter.sample03_bdd;

import com.spdeveloper.mockitostarter.model.Person;
import com.spdeveloper.mockitostarter.persistence.PersonJpaRepository;
import com.spdeveloper.mockitostarter.persistence.PersonPersistenceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BDDExample {

    @Mock
    PersonJpaRepository personJpaRepository;

    @InjectMocks
    PersonPersistenceImpl personPersistence;

    @Test
    void findById() {
        //Given:
        Person person = new Person();
        /*when(personJpaRepository.findById(1L)).thenReturn(java.util.Optional.of(person));*/
        given(personJpaRepository.findById(1L)).willReturn(java.util.Optional.of(person));

        //When:
        Person searchResult = personPersistence.findById(1L);

        //Then:
        assertThat(searchResult).isNotNull();
        assertThat(searchResult).isEqualTo(person);
        /*verify(personJpaRepository).findById(1L);*/
        then(personJpaRepository).should().findById(1L);


    }
}
