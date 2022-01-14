package com.omidmohebbise.todoapp.identity.config;

import com.omidmohebbise.todoapp.identity.config.model.TokenProvider;
import com.omidmohebbise.todoapp.identity.model.RoleEntity;
import com.omidmohebbise.todoapp.identity.model.UserEntity;
import com.omidmohebbise.todoapp.identity.usecase.FindUserByUsernameUC;
import com.omidmohebbise.todoapp.identity.usecase.dto.AuthenticationResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class SecurityService {



}
