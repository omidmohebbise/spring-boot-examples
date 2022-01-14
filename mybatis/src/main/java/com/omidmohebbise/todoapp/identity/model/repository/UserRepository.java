package com.omidmohebbise.todoapp.identity.model.repository;

import com.omidmohebbise.todoapp.identity.model.UserEntity;

import java.util.Optional;


public interface UserRepository  {

     Optional<UserEntity> findUserByUsername(String username);

     Optional<UserEntity> findById(Long id);

     UserEntity save(UserEntity userEntity);
}
