package com.omidmohebbise.springapachecamel.config;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfig implements CommandLineRunner {

    @Autowired
    CamelContext camelContext;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello");
    }
}
