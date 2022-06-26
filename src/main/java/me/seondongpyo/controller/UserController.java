package me.seondongpyo.controller;

import lombok.RequiredArgsConstructor;
import me.seondongpyo.application.UserService;
import me.seondongpyo.dto.UserRegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
}
