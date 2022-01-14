package com.omidmohebbise.todoapp.identity.usecase;

import com.omidmohebbise.todoapp.identity.model.UserEntity;
import com.omidmohebbise.todoapp.identity.model.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class FindUserByUsernameUC {
    private UserRepository userRepository;

    public FindUserByUsernameUC(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity find(String username){
        return userRepository.findUserByUsername(username).orElseThrow(() -> new RuntimeException("The user not found."));

    }
}