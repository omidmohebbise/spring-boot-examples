package com.omidmohebbise.todoapp.identity.usecase;

import com.omidmohebbise.todoapp.identity.model.User;
import com.omidmohebbise.todoapp.identity.model.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class GetCurrentUserUC {

    private final UserRepository userRepository;

    public GetCurrentUserUC(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        return userRepository.findUserByUsername(userDetails.getUsername()).orElseThrow(() -> new SecurityException("Something is wrong"));

    }
}
