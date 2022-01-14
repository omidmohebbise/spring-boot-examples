package com.omidmohebbise.todoapp.identity.model.repository;

import com.omidmohebbise.todoapp.identity.model.User;

import java.util.Optional;


public interface UserRepository {

    Optional<User> findUserByUsername(String username);

    Optional<User> findById(Long id);

    User insert(User userEntity);

    void update(User user);
}
