package com.omidmohebbise.todoapp.identity.config;


import com.omidmohebbise.todoapp.identity.model.UserEntity;
import com.omidmohebbise.todoapp.identity.config.model.UserPrincipal;
import com.omidmohebbise.todoapp.identity.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserEntity user = userRepository.findUserByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with : " + username)
                );
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found.")
        );

        return UserPrincipal.create(user);
    }
}
