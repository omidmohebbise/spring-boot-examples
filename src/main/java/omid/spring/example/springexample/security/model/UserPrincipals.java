package omid.spring.example.springexample.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserPrincipals implements UserDetails {

    private User user;
    private List<AuthGroup> authGroups;

    public UserPrincipals(User user, List<AuthGroup> authGroups) {
        this.user = user;
        this.authGroups = authGroups;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //return Collections.singleton(new SimpleGrantedAuthority("USER"));
        if(authGroups == null){
            return Collections.emptySet();
        }else{
            Set<SimpleGrantedAuthority>grantedAuthorities = new HashSet<>();
            authGroups.forEach(group->{
                grantedAuthorities.add(new SimpleGrantedAuthority(group.getAuthgroup()));
            });
            return grantedAuthorities;
        }

    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
