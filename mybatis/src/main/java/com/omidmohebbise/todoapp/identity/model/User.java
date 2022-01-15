package com.omidmohebbise.todoapp.identity.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String token;
    private Date expireDate;
    private Boolean rememberMe;
    private Role role;

}
