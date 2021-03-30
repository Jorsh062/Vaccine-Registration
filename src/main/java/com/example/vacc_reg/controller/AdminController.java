package com.example.vacc_reg.controller;


import com.example.vacc_reg.model.Roles;
import com.example.vacc_reg.model.User;
import com.example.vacc_reg.service.*;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class AdminController {

    private RoleService roleService;
    private UserService userService;
    private ApplicationService applicationService;

    public AdminController(RoleServiceImpl roleService, UserServiceImpl userService, ApplicationServiceImpl applicationService) {
        this.roleService = roleService;
        this.userService= userService;
        this.applicationService = applicationService;
    }

    @RequestMapping("/admin")
    public String adminPage(@CurrentSecurityContext(expression = "authentication.name") String email, Model model) {

        model.addAttribute("applicationService", applicationService);
        return "admin/admin";
    }



    @GetMapping("/admin/create")
    public String showFormPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        Set<Roles> rolesSet = new HashSet<>();
        rolesSet.add(roleService.findRolesByName("Admin"));
        rolesSet.add(roleService.findRolesByName("Health"));
        model.addAttribute("roleSet", rolesSet);

        return "admin/form";
    }

    @PostMapping("/admin/create")
    public String saveCreatedUser(@ModelAttribute User user, Model model) {
        if (userService.findUserByEmail(user.getEmail()) != null) {
            model.addAttribute("emailError", "Error: Email already exists");
            model.addAttribute("user", new User());

            return "admin/form";
        }
        else {
            User savedUser = userService.save(user);
            model.addAttribute("user",savedUser);
        }
        return "admin/createdUser";
    }

    /*
    @PostMapping("/admin/form/create")
    public String displayCreatedUser(@ModelAttribute User user, Model model, @CurrentSecurityContext(expression = "authentication.name") String email) {
        userService.findUserByEmail(email);
        userService.save(user);

        model.addAttribute("user",user);

        return "admin/createdUser";
    }

     */

}
