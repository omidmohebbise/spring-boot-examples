package com.spdeveloper.mockitostarter.sample02;

import com.spdeveloper.mockitostarter.model.Person;
import com.spdeveloper.mockitostarter.persistence.PersonJpaRepository;
import com.spdeveloper.mockitostarter.persistence.PersonPersistenceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UseWhen {

    @Mock
    PersonJpaRepository personJpaRepository;

    @InjectMocks
    PersonPersistenceImpl personPersistence;

    @Test
    void findById(){
        Person person = new Person();

        when(personJpaRepository.findById(1L)).thenReturn(java.util.Optional.of(person));
        Person searchResult = personPersistence.findById(1L);
        assertThat(searchResult).isNotNull();
        assertThat(searchResult).isEqualTo(person);

        verify(personJpaRepository).findById(1L);

    }
}
