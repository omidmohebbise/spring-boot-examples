package omid.spring.example.springexample.bookstore.controllers;

import omid.spring.example.springexample.bookstore.repositories.BooksRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
