package me.seondongpyo.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SecurityController.class)
@Import(SecurityConfiguration.class)
class SecurityControllerTest {

    @Autowired
    private MockMvc mvc;

    @DisplayName("'/' 경로는 누구나 접근할 수 있다.")
    @Test
    void home() throws Exception {
        mvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(content().string("home"));
    }

    @DisplayName("'/manager' 하위 경로는 MANAGER와 ADMIN만 접근할 수 있다.")
    @WithMockUser(roles = {"MANAGER", "ADMIN"})
    @Test
    void manager() throws Exception {
        mvc.perform(get("/manager"))
            .andExpect(status().isOk())
            .andExpect(content().string("manager or admin"));
    }

    @DisplayName("'/manager' 하위 경로에 일반 사용자가 접근할 경우, 403 응답을 내려준다.")
    @WithMockUser
    @Test
    void cannotAccessManagerPath() throws Exception {
        mvc.perform(get("/manager"))
            .andExpect(status().isForbidden());
    }
}
