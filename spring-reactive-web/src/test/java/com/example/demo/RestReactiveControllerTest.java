package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "120000")
@TestPropertySource(locations = "classpath:application-test.properties")
@Import(RestReactiveControllerTest.EmployeeServiceImplTestContextConfiguration.class)
class RestReactiveControllerTest {


    @Autowired
    private WebTestClient webTestClient;


    @Autowired
    private Conf1 conf1;

    @Test
    void shouldReturnHelloWorld() {
        webTestClient.get().uri("/hello-world").exchange().expectStatus().isOk().expectBody(String.class).isEqualTo("Hello World");

        assertEquals(conf1.stringTest("!"), "Hello World!");
    }
    public class Conf1{

        public String stringTest(String str) {
            return  "Hello World" + str;
        }
    }

    @TestConfiguration
    public  class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public Conf1 conf1(){
            return new Conf1();
        }

    }
}