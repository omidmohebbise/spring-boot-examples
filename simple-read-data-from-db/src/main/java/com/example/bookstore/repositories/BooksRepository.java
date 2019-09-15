package com.example.bookstore.repositories;


import com.example.bookstore.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Book,Long> {
}
