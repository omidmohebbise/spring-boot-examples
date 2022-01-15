package com.omidmohebbise.todoapp.identity.usecase.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@AllArgsConstructor
@Getter
@Setter
@Builder
public class SignInRequestDto {
    @NotBlank(message = "The username is required.")
    private String username;
    @NotBlank(message = "The password is required.")
    private String password;
    private boolean rememberMe;
}
