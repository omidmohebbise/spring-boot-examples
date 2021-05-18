package com.example.bookstore.service;


import com.example.bookstore.entity.Author;
import org.springframework.data.repository.CrudRepository;

interface MyInterface {

     Iterable<Author> findByName(String omid);
     Iterable<Author> findByFamily(String family);

}

public interface AuthorsRepository extends MyInterface, CrudRepository<Author,Long> {



}
