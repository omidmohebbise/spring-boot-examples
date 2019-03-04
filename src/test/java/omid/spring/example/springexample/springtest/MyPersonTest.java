package omid.spring.example.springexample.springtest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyPersonTest {

    MyPerson myPerson;

    //@Before
    public void setUp() throws Exception {
        System.out.println("*****brfore*****" );
        myPerson = new MyPerson();
    }

    //@Test
    public void getId() {
        Long tId = 50L;
        myPerson.setId(tId);
        assertEquals(myPerson.getId(),tId);
    }

    //@Test
    public void getName() {
    }

    //@Test
    public void getFamily() {
    }
}