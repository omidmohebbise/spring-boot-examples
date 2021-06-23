package com.spdeveloper.mockitostarter.sample04_exception;

import com.spdeveloper.mockitostarter.model.Person;
import com.spdeveloper.mockitostarter.persistence.PersonJpaRepository;
import com.spdeveloper.mockitostarter.persistence.PersonPersistenceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ExceptionSample {

    @Mock
    PersonJpaRepository personJpaRepository;

    @InjectMocks
    PersonPersistenceImpl personPersistence;

    @Test
    void testDoThrow() {
        doThrow(new RuntimeException("boom")).when(personJpaRepository).delete(any());

        assertThrows(RuntimeException.class,()->personPersistence.delete(new Person()));

        verify(personJpaRepository).delete(any());
    }


    @Test
    void testDoThrowBDDStyle1() {
        //doThrow(new RuntimeException("boom")).when(personJpaRepository).delete(any());
        willThrow(new RuntimeException("boom")).given(personJpaRepository).delete(any());

        assertThrows(RuntimeException.class,()->personPersistence.delete(new Person()));

        //verify(personJpaRepository).delete(any());
        then(personJpaRepository).should().delete(any());
    }

    @Test
    void testDoThrowBDDStyle2() {
        given(personJpaRepository.findById(any())).willThrow(new RuntimeException("boom"));

        assertThrows(RuntimeException.class,()->personPersistence.findById(1L));

        then(personJpaRepository).should().findById(any());
    }
}
