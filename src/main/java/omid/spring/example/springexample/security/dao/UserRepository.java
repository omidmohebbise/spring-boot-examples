package omid.spring.example.springexample.security.dao;

import omid.spring.example.springexample.security.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User , Long> {
    public User findByUsername(String username);
}
