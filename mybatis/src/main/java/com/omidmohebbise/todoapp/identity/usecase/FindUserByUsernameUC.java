package com.omidmohebbise.todoapp.identity.usecase;

import com.omidmohebbise.todoapp.identity.model.User;
import com.omidmohebbise.todoapp.identity.model.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindUserByUsernameUC {
    private final UserRepository userRepository;

    public FindUserByUsernameUC(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findOrThrow(String username){
        return userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("The user not found."));
    }
    public Optional<User> find(String username){
        return userRepository.findUserByUsername(username);
    }
}
