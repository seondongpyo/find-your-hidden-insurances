package me.seondongpyo.controller;

import me.seondongpyo.application.UserService;
import me.seondongpyo.config.SecurityConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@Import(SecurityConfiguration.class)
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

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
}
