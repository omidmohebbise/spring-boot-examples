package com.omidmohebbise.todoapp.identity.model.repository.impl;

import com.omidmohebbise.todoapp.identity.model.User;

import java.util.Optional;

//@Repository
public interface UserJpaRepository  {

    Optional<User> findUserByUsername(String username);
}
