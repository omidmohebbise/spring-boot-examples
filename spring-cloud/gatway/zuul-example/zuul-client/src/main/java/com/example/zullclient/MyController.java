package com.example.zullclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class MyController {

    @Autowired
    private Environment env;

    @RequestMapping("/hello")
    public String status() {
        return "Working on port " + env.getProperty("local.server.port");
    }
}
