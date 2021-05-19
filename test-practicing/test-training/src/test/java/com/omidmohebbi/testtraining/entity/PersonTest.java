package com.omidmohebbi.testtraining.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void builder() {
        System.out.println("Hello");
        Person person = Person.builder().build();
        assertNotNull(person);

    }
}
