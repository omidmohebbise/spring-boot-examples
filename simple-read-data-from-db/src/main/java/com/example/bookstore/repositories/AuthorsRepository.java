package com.example.bookstore.repositories;


import com.example.bookstore.model.Author;

interface MyInterface {
     Iterable<Author> findByName(String omid);
}

public interface AuthorsRepository extends MyInterface{//,CrudRepository<Author,Long> {



}
