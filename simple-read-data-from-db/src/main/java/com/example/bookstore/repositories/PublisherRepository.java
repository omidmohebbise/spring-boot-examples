package omid.spring.example.springexample.bookstore.repositories;

import omid.spring.example.springexample.bookstore.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
