package com.omidmohebbise.todoapp.identity.usecase.guard;

import com.omidmohebbise.todoapp.identity.usecase.FindUserByUsernameUC;
import org.springframework.stereotype.Service;

@Service
public class RepetitiveUsernameGuard {
    private final FindUserByUsernameUC findUserByUsernameUC;

    public RepetitiveUsernameGuard(FindUserByUsernameUC findUserByUsernameUC) {
        this.findUserByUsernameUC = findUserByUsernameUC;
    }

    public void validate(String username) {
        if (findUserByUsernameUC.find(username).isPresent()) {
            throw new SecurityException("The username is already in use.");
        }
    }
}
