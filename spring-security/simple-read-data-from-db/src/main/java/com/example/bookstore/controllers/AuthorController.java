package com.example.bookstore.controllers;

import com.example.bookstore.service.AuthorsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    AuthorsRepository authorsRepository ;

    public AuthorController(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    @RequestMapping("/authors")
    public String getGetAuthors(Model model){
        model.addAttribute("authors", authorsRepository.findAll());
        return "authors";
    }
}
