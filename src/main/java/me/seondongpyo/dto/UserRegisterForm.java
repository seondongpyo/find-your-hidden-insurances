package me.seondongpyo.dto;

import lombok.Getter;
import lombok.Setter;
import me.seondongpyo.domain.Role;
import me.seondongpyo.domain.User;

@Getter
@Setter
public class UserRegisterForm {

    private String name;
    private String username;
    private String password;
    private Role role;

    public User toUser() {
        return new User(name, username, password, role);
    }
}
