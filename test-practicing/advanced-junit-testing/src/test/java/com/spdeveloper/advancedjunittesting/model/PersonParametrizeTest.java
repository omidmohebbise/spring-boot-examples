package com.spdeveloper.advancedjunittesting.model;

import static org.junit.jupiter.api.Assertions.*;

import com.spdeveloper.advancedjunittesting.provider.CustomArgsProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class PersonParametrizeTest {

    @ParameterizedTest
    @ValueSource(strings={"Omid" , "Amir" , "Hossein"})
    void testDifferentNames(String val){
        Person person = new Person(val, "");
        assertEquals(person.getName(),val);
    }
    //////////////////////////////////////////////////////////////////////
    @DisplayName("Parametrized Test -- ")
    @ParameterizedTest(name = "{displayName} - [{index}] - {arguments}")
    @ValueSource(strings={"Omid" , "Amir" , "Hossein"})
    void testDifferentNamesBuDisplayName(String val){
        Person person = new Person(val, "");
        assertEquals(person.getName(),val);
    }

    /////////////////////////////////////////////////////////////////////
    @DisplayName("CSV Input Test")
    @ParameterizedTest(name = "{displayName} - [{index}] - {arguments}")
    @CsvSource({
            "omid , mohebbi",
            "amir , mohebbi",
            "hamed , ahmadi",
    })
    void testDifferentNamesCSV(String name,String family){
        Person person = new Person(name, family);
        System.out.println(person.toString());
    }

    //////////////////////////////////////////////////////////////////////

    @DisplayName("CSV File Input Test")
    @ParameterizedTest(name = "{displayName} - [{index}] - {arguments}")
    @CsvFileSource(resources = "/input.csv",numLinesToSkip = 1)
    void testDifferentNamesCSVFile(String name,String family){
        Person person = new Person(name, family);
        System.out.println(person.toString());
    }

   //////////////////////////////////////////////////////////////
    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] - {arguments}")
    @MethodSource("getArgs")
    void testUseMethodArgsProvider(String name,String family){
        Person person = new Person(name, family);
        System.out.println(person.toString());
    }

    static Stream<Arguments> getArgs(){
        return Stream.of(
                Arguments.arguments("omid","mohebbi"),
                Arguments.arguments("amir","mohebbi"),
                Arguments.arguments("sara","ahmadi")
                );
    }

    ////////////////////////////////////////////////////////////////////////
    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] - {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void testUseCustomArgsProvider(String name,String family){
        Person person = new Person(name, family);
        System.out.println(person.toString());
    }


}
