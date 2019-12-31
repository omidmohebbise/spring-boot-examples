package com.example.bookstore.service;


import com.example.bookstore.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Book,Long> {
}
