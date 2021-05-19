package com.spdeveloper.advancedjunittesting.model;

import com.spdeveloper.advancedjunittesting.fnd.ModelTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatTest implements ModelTest {
    @Test
    void createCat() {
        Cat cat = new Cat("Kitty", (short) 1);
        assertAll("Cat factory:",
                () -> assertEquals(cat.getName(), "Kitty"),
                () -> assertEquals(cat.getAge(), 1));
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all in Cat test case");
    }
}
