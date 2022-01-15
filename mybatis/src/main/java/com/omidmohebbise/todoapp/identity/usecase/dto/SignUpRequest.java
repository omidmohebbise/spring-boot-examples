package com.omidmohebbise.todoapp.identity.usecase.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Getter @Setter
@Builder
public class SignUpRequest {

    @NotBlank(message = "The username is required.")
    private String username;
    @NotBlank(message = "The first name is required.")
    private String firstName;
    @NotBlank(message = "The last name is required.")
    private String lastName;
    @NotBlank(message = "The password is required.")
    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",message="Weak password.")
    private String password;

}
