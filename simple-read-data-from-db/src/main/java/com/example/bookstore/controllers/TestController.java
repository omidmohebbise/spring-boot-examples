package com.example.bookstore.controllers;

import com.example.bookstore.repositories.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    public AuthorsRepository authorsRepository;

    public TestController(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    public static String file  = "";
    @GetMapping("/getAuther")
    public Object getAuther(){
        file = "";
        authorsRepository.findAll().forEach(author -> {
            file = file + "\t" + author.getName();

        });
        return file;

    }


    @GetMapping("/findAuther")
    public Object findAuther(@RequestParam String name){
        file = "";
        authorsRepository.findByName(name).forEach(author -> {
            file = file + "\t" + author.getName();

        });
        return file;

    }


    @GetMapping("/findbyfamily")
    public Object findByFamily(@RequestParam String family){
        file = "";
        authorsRepository.findByFamily(family).forEach(author -> {
            file = file + "\t" + author.getName() + " " + author.getFamily();

        });
        return file;

    }
}
