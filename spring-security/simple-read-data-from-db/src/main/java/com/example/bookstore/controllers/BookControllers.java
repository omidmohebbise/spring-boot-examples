package com.example.bookstore.controllers;


import com.example.bookstore.service.BooksRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookControllers {

    private BooksRepository booksRepository;

    public BookControllers(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books",booksRepository.findAll());
        return "books";
    }

}
