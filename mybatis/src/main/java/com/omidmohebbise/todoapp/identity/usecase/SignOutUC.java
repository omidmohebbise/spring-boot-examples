package com.omidmohebbise.todoapp.identity.usecase;

import com.omidmohebbise.todoapp.identity.model.User;
import com.omidmohebbise.todoapp.identity.model.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignOutUC {
    private GetCurrentUserUC getCurrentUserUC;
    private UserRepository userRepository;

    public SignOutUC(GetCurrentUserUC getCurrentUserUC, UserRepository userRepository) {
        this.getCurrentUserUC = getCurrentUserUC;
        this.userRepository = userRepository;
    }

    @Transactional
    public void execute() {
        User user = getCurrentUserUC.execute();
        user.setToken(null);
        user.setLastRefresh(null);
        userRepository.insert(user);
    }
}
