package omid.spring.example.springexample.readdata;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface MyPersonRepo extends CrudRepository<MyPerson , Long> {
}
