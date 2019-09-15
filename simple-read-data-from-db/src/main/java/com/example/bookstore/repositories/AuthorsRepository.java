package com.example.bookstore.repositories;


import com.example.bookstore.model.Author;
import org.springframework.data.repository.CrudRepository;

interface MyInterface {
     Iterable<Author> findByName(String omid);
}

public interface AuthorsRepository extends MyInterface, CrudRepository<Author,Long> {



}
