package me.seondongpyo.controller;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import me.seondongpyo.application.UserService;
import me.seondongpyo.config.SecurityConfiguration;
import me.seondongpyo.domain.Role;
import me.seondongpyo.domain.User;

@WebMvcTest(UserController.class)
@Import(SecurityConfiguration.class)
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @BeforeEach
    void setUp() {
        User user = new User("유저", "user", "1234", Role.USER);
        given(userService.findById(1L)).willReturn(user);
    }

    @DisplayName("사용자 등록 폼으로 이동한다.")
    @Test
    void registerForm() throws Exception {
        mvc.perform(get("/user/register"))
            .andExpect(status().isOk())
            .andExpect(view().name("user/register"));
    }

    @DisplayName("사용자 등록 폼으로 새로운 사용자를 등록한다.")
    @Test
    void register() throws Exception {
        mvc.perform(post("/user/register")
                .param("name", "홍길동")
                .param("username", "hong")
                .param("password", "1234"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/login"));
    }

    @DisplayName("사용자 정보 상세 페이지로 이동한다.")
    @WithAuthUser(username = "유저", role = Role.USER)
    @Test
    void detail() throws Exception {
        mvc.perform(get("/user/detail"))
            .andExpect(status().isOk())
            .andExpect(view().name("user/detail"));
    }
}
