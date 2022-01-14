package com.omidmohebbise.todoapp.identity.usecase.dto;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@Builder
public class AuthenticationResponseDto {
    private String token;
}
