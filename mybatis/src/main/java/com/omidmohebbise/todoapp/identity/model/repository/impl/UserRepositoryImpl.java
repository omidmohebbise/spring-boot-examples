package com.omidmohebbise.todoapp.identity.model.repository.impl;

import com.omidmohebbise.todoapp.identity.model.User;
import com.omidmohebbise.todoapp.identity.model.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepositoryImpl implements UserRepository {
    private final UserMapper userMapper;

    public UserRepositoryImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return Optional.ofNullable(userMapper.findUserByUsername(username));
    }

    @Override
    public Optional<User> findById(Long id) {
        return userMapper.findById(id);

    }

    @Override
    public User insert(User user) {
        userMapper.insert(user);
        return userMapper.findUserByUsername(user.getUsername());
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }
}
