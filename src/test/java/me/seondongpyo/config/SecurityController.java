package me.seondongpyo.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/manager")
    public String manager() {
        return "manager or admin";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
