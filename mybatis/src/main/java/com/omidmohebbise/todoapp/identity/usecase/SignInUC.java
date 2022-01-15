package com.omidmohebbise.todoapp.identity.usecase;

import com.omidmohebbise.todoapp.identity.config.model.TokenProvider;
import com.omidmohebbise.todoapp.identity.model.User;
import com.omidmohebbise.todoapp.identity.usecase.dto.AuthenticationRequestDto;
import com.omidmohebbise.todoapp.identity.usecase.dto.AuthenticationResponseDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class SignInUC {

    @Qualifier("ClientTokenProvider")
    private final TokenProvider tokenProvider;
    private final FindUserByUsernameUC findUserByUsernameUC;

    public SignInUC(TokenProvider tokenProvider, FindUserByUsernameUC findUserByUsernameUC) {
        this.tokenProvider = tokenProvider;
        this.findUserByUsernameUC = findUserByUsernameUC;
    }


    public AuthenticationResponseDto execute(AuthenticationRequestDto authenticationRequestDto) {
        User user = findUserByUsernameUC.findOrThrow(authenticationRequestDto.getUsername());
        Authentication authentication;
        authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList("USER_ROLE"));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return AuthenticationResponseDto.builder()
                .token(tokenProvider.createToken(authentication, authenticationRequestDto.isRememberMe()))
                .build();
    }

}
