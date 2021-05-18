package com.security.sql.securitysql.dao;

import com.security.sql.securitysql.model.AuthGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthGroupRepository extends CrudRepository<AuthGroup , Long> {
    List<AuthGroup> findByUsername(String username);
}
