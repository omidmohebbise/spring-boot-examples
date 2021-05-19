package com.spdeveloper.advancedjunittesting.model;

import com.spdeveloper.advancedjunittesting.fnd.ModelTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//@Tag("Model")// use for execute special tests by tag name
class PersonTest implements ModelTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all in Person test case");
    }

    @Test
    void groupedAssertion() {
        Person person = new Person("omid", "mohebbi");
        assertAll("Test properties:",
                () -> assertEquals(person.getName(), "omid", "First Name Failed"),
                () -> assertEquals(person.getFamily(), "mohebbi", "Last Name Failed"));
    }

    @DisplayName("first name and last name must not be equal")
    @Test
    void displayTestName() {
        Person person = new Person("omid", "mohebbi");
        assertNotEquals(person.getName(), person.getFamily());
    }

    @RepeatedTest(value = 2,name = "{displayName} {currentRepetition}-{totalRepetitions}")
    void repeatTestName() {
        Person person = new Person("omid", "mohebbi");
        assertNotEquals(person.getName(), person.getFamily());
        System.out.println("repeated test");
    }
}
