package com.example.bookstore.service;

import com.example.bookstore.entity.Author;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorPaginationRepository extends PagingAndSortingRepository<Author , Long> {

}
