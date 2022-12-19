package com.omidmohebbise.webflox;

import org.springframework.web.reactive.function.client.WebClient;

public class EmployeeWebClient {
    WebClient client = WebClient.create("http://localhost:9192");

}
