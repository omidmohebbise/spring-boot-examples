package com.omid.dev.tools.devtools;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {


    @GetMapping("/helloworld")
    public String getHelloWorld(){
        return "hello World";
    }
}
