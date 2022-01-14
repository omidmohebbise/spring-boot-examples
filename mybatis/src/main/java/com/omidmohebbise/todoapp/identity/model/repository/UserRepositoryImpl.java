package com.omidmohebbise.todoapp.identity.model.repository;

import com.omidmohebbise.todoapp.identity.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepositoryImpl implements UserRepository {
    private UserJpaRepository userJpaRepository;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }


    @Override
    public Optional<UserEntity> findUserByUsername(String username) {
        return userJpaRepository.findUserByUsername(username);
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userJpaRepository.findById(id);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userJpaRepository.save(userEntity);
    }
}
