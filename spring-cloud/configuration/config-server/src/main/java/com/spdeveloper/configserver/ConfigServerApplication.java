package com.spdeveloper.configserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication{
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
