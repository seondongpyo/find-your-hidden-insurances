package me.seondongpyo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import me.seondongpyo.application.UserService;
import me.seondongpyo.domain.User;
import me.seondongpyo.dto.UserRegisterForm;
import me.seondongpyo.dto.UserResponseDTO;
import me.seondongpyo.security.AuthUser;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("form", new UserRegisterForm());
        return "user/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("form") UserRegisterForm form) {
        userService.create(form.toUser());
        return "redirect:/login";
    }

    @GetMapping("/detail")
    public String detail(@AuthenticationPrincipal AuthUser authUser,
                         Model model) {
        User user = userService.findById(authUser.getId());
        model.addAttribute("user", new UserResponseDTO(user));
        return "user/detail";
    }
}
