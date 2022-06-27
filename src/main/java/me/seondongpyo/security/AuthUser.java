package me.seondongpyo.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

@Getter
public class AuthUser extends User {

    public AuthUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public AuthUser(me.seondongpyo.domain.User user) {
        this(user.getUsername(), user.getPassword(),
            List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole())));
    }
}
