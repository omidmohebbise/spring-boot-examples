package omid.spring.example.springexample.security.dao;

import omid.spring.example.springexample.security.model.AuthGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthGroupRepository extends CrudRepository<AuthGroup , Long> {
    List<AuthGroup> findByUsername(String username);
}
