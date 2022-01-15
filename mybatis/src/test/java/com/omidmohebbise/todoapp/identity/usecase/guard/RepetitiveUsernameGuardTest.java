package com.omidmohebbise.todoapp.identity.usecase.guard;

import com.omidmohebbise.todoapp.identity.model.User;
import com.omidmohebbise.todoapp.identity.usecase.FindUserByUsernameUC;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class RepetitiveUsernameGuardTest {

    @InjectMocks
    RepetitiveUsernameGuard repetitiveUsernameGuard;
    @Mock
    FindUserByUsernameUC findUserByUsernameUC;
    @Mock
    User user;

    @Test
    void validate() {
        String username = "testUsername";
        when(findUserByUsernameUC.find(username)).thenReturn(Optional.of(user));

        assertThrows(SecurityException.class, ()-> repetitiveUsernameGuard.validate(username));

    }
}