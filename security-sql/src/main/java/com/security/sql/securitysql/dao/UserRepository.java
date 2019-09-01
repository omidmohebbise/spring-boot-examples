package com.security.sql.securitysql.dao;

import com.security.sql.securitysql.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User , Long> {
    public User findByUsername(String username);
}
