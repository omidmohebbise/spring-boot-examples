package com.omidmohebbise.springgrafanaprometheus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public ResponseEntity<String> getHelloWorld(){
        return ResponseEntity.ok("Hello World");
    }
}
