package com.omidmohebbise.wiremock.springwiremock.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class HelloService{


    @Value("${helloWorldAPI}")
    private String HelloWorldURL;


    public String getThirdPartyHelloWorld() {
        return Objects.requireNonNull(WebClient.create(HelloWorldURL)
                .get()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve().bodyToFlux(MessageDTO.class).blockFirst()).message();
    }
}
