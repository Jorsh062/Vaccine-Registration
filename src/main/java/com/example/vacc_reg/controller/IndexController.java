package com.example.vacc_reg.controller;

import com.example.vacc_reg.model.User;
import com.example.vacc_reg.service.UserService;
import com.example.vacc_reg.service.UserServiceImpl;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    public IndexController(UserServiceImpl userService) {
        this.userService = userService;
    }

    private final UserService userService;

    @RequestMapping({"/", "/index"})
    public String getIndexPage(@CurrentSecurityContext(expression = "authentication.name") String email, Model model) {

        User user = userService.findUserByEmail(email);
        model.addAttribute("currentUser",user);
        return "home";
    }
}

