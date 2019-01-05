package omid.spring.example.springexample.bookstore.repositories;

import omid.spring.example.springexample.bookstore.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Book,Long> {
}
