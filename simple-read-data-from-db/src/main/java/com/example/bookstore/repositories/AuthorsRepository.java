package omid.spring.example.springexample.bookstore.repositories;

import omid.spring.example.springexample.bookstore.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorsRepository extends CrudRepository<Author,Long> {


}
