package com.omidmohebbise.todoapp.identity.usecase.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
@Builder
public class SignUpRequest {

    private String username;
    private String firstName;
    private String lastName;
    private String password;

}
