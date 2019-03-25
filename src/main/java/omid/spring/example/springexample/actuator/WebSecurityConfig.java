package omid.spring.example.springexample.actuator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/actuator/*").permitAll()
                .antMatchers("/actuator/*/*").permitAll()
                //.antMatchers("/*").permitAll()
                //.antMatchers("/actuator/*").permitAll()
                //.antMatchers("/ineedadminrole").hasRole("admin")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();




    }

// In memory users

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        List<UserDetails> users = new ArrayList<>();

        //for(int i = 0 ; i < 10)
        UserDetails user01 = User.withDefaultPasswordEncoder()
                .username("user1")
                .password("password")
                .roles("USER")
                .build();
        UserDetails user02 = User.withDefaultPasswordEncoder()
                .username("user2")
                .password("password")
                .roles("admin")
                .build();
        UserDetails user03 = User.withDefaultPasswordEncoder()
                .username("user3")
                .password("password")
                .roles("MANAGER")
                .build();

        users.add(user01);
        users.add(user02);
        users.add(user03);
       /* UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();*/


        return new InMemoryUserDetailsManager(users);
    }
}
