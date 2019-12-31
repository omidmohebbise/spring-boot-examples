package com.example.bookstore.controllers;


import com.example.bookstore.entity.Author;
import com.example.bookstore.service.AuthorPaginationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthorPagingController implements CommandLineRunner {

    @Autowired
    AuthorPaginationRepository authorPaginationRepository;

    @GetMapping("/authorspagin")
    public ResponseEntity<List<Author>> getAuthors(@RequestParam int page , @RequestParam int size){

        Pageable paging = PageRequest.of(page, size, Sort.by("name"));

        Page<Author> pagedResult = authorPaginationRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return ResponseEntity.status(HttpStatus.OK).body(pagedResult.getContent());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<Author>());
        }
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
