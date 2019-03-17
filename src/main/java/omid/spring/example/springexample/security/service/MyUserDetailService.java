package omid.spring.example.springexample.security.service;

import omid.spring.example.springexample.security.dao.AuthGroupRepository;
import omid.spring.example.springexample.security.dao.UserRepository;

import omid.spring.example.springexample.security.model.AuthGroup;
import omid.spring.example.springexample.security.model.User;
import omid.spring.example.springexample.security.model.UserPrincipals;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {
    private UserRepository userRepository;
    private AuthGroupRepository authGroupRepository;

    public MyUserDetailService(UserRepository userRepository, AuthGroupRepository authGroupRepository) {
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
           throw new UsernameNotFoundException("user ("+username+") not found exception ");
        }else{

            List<AuthGroup> authGroups = authGroupRepository.findByUsername(username);
            return new UserPrincipals(user, authGroups);
        }
    }



}
