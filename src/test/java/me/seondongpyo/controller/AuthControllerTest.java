package me.seondongpyo.controller;

import me.seondongpyo.application.UserService;
import me.seondongpyo.config.SecurityConfiguration;
import me.seondongpyo.domain.Role;
import me.seondongpyo.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Import(SecurityConfiguration.class)
class AuthControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserService userService;

    @DisplayName("로그인 폼 페이지로 이동한다.")
    @Test
    void loginForm() throws Exception {
        mvc.perform(get("/login"))
            .andExpect(status().isOk())
            .andExpect(view().name("user/login"));
    }

    @DisplayName("로그인 폼으로 로그인한다.")
    @Test
    void loginSuccess() throws Exception {
        userService.create(new User("홍길동", "hong", "1234", Role.USER));

        mvc.perform(formLogin()
                .user("hong")
                .password("1234"))
            .andExpect(authenticated().withRoles("USER"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/"));
    }

    @DisplayName("사용자가 존재하지 않으면 로그인을 실패한다.")
    @Test
    void loginFailure() throws Exception {
        mvc.perform(formLogin()
                .user("kim")
                .password("1234"))
            .andExpect(unauthenticated())
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/login?error"));
    }
}
