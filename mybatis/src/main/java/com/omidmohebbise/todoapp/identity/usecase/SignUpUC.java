package com.omidmohebbise.todoapp.identity.usecase;

import com.omidmohebbise.todoapp.identity.model.User;
import com.omidmohebbise.todoapp.identity.model.repository.UserRepository;
import com.omidmohebbise.todoapp.identity.usecase.dto.SignUpRequest;
import com.omidmohebbise.todoapp.identity.usecase.guard.RepetitiveUsernameGuard;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignUpUC {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RepetitiveUsernameGuard repetitiveUsernameGuard;

    public SignUpUC(PasswordEncoder passwordEncoder, UserRepository userRepository, RepetitiveUsernameGuard repetitiveUsernameGuard) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.repetitiveUsernameGuard = repetitiveUsernameGuard;
    }

    @Transactional
    public void execute(SignUpRequest signUpRequest) {
        repetitiveUsernameGuard.validate(signUpRequest.getUsername());

        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        userRepository.insert(user);
    }

}
