package com.omidmohebbise.todoapp.identity.usecase;

import com.omidmohebbise.todoapp.identity.model.UserEntity;
import com.omidmohebbise.todoapp.identity.model.repository.UserRepository;
import com.omidmohebbise.todoapp.identity.usecase.dto.SignUpRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignUpUC {
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public SignUpUC(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Transactional
    public boolean execute(SignUpRequest signUpRequest) {
        UserEntity user = new UserEntity();
        user.setUsername(signUpRequest.getUsername());
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setActive(true);
        userRepository.save(user);
        return true;
    }

}
