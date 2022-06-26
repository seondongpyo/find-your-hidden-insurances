package me.seondongpyo.controller;

import lombok.RequiredArgsConstructor;
import me.seondongpyo.dto.UserRegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("form", new UserRegisterForm());
        return "user/register";
    }
}
