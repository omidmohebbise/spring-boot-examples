package com.omidmohebbise.todoapp.identity.usecase.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
@Builder
public class AuthenticationRequestDto {
    private String username;
    private String password;
    private boolean rememberMe;
}
