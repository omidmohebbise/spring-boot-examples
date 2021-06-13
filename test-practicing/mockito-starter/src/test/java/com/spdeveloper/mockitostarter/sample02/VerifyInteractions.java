package com.spdeveloper.mockitostarter.sample02;

import com.spdeveloper.mockitostarter.persistence.PersonJpaRepository;
import com.spdeveloper.mockitostarter.persistence.PersonPersistenceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class VerifyInteractions {

    @Mock
    PersonJpaRepository personJpaRepository;

    @InjectMocks
    PersonPersistenceImpl persistence;

    @Test
    void deleteById() {
        persistence.deleteById(1L);
        verify(personJpaRepository).deleteById(1L);
    }

    @Test
    void deleteByIdTwoTimes() {
        persistence.deleteById(1L);
        persistence.deleteById(1L);
        verify(personJpaRepository,times(2)).deleteById(1L);
    }

    @Test
    void deleteByIdAtLeastOnce() {
        persistence.deleteById(1L);
        persistence.deleteById(1L);
        verify(personJpaRepository, atLeastOnce()).deleteById(1L);
    }

    @Test
    @Disabled
    void deleteByIdAtMost() {
        persistence.deleteById(1L);
        persistence.deleteById(1L);
        verify(personJpaRepository, atMost(1)).deleteById(1L);
    }

    @Test
    @Disabled
    void deleteByIdNever() {
        persistence.deleteById(1L);
        persistence.deleteById(1L);
        verify(personJpaRepository, never()).deleteById(1L);
    }
}
