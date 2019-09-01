package omid.spring.example.springexample.bookstore.controllers;

import omid.spring.example.springexample.bookstore.repositories.AuthorsRepository;
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
