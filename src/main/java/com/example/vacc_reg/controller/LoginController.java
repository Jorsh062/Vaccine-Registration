package com.example.vacc_reg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String viewLoginPage() {
        // custom logic before showing login page...

        return "login/login";
    }
}
