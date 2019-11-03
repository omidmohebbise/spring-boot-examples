package com.example.bookstore.repositories;


import com.example.bookstore.model.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.beans.Transient;

interface MyInterface {

     Iterable<Author> findByName(String omid);
     Iterable<Author> findByFamily(String family);

}

public interface AuthorsRepository extends MyInterface, CrudRepository<Author,Long> {



}
