package com.omidmohebbise.wiremock.springwiremock.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class HelloServiceTest {


    @Autowired
    HelloService helloService;

    @Test
    void getThirdPartyHelloWorld() {
        assertTrue(helloService.getThirdPartyHelloWorld().contains("Hello"));
    }
}