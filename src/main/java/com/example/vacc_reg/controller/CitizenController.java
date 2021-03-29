package com.example.vacc_reg.controller;

import com.example.vacc_reg.model.Application;
import com.example.vacc_reg.model.User;
import com.example.vacc_reg.service.ApplicationServiceImpl;
import com.example.vacc_reg.service.RoleServiceImpl;
import com.example.vacc_reg.service.UserServiceImpl;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class CitizenController {

    ApplicationServiceImpl applicationService;

    RoleServiceImpl roleService;

    UserServiceImpl userService;

    public CitizenController(ApplicationServiceImpl applicationService, RoleServiceImpl roleService, UserServiceImpl userService) {
        this.applicationService = applicationService;
        this.roleService = roleService;
        this.userService = userService;
    }


    @GetMapping("/register")
    public String showFormPage(Model model) {
        User user = new User();
        model.addAttribute("citizen", user);

        return "citizenForm";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute User user, Model model) {

        if(userService.findUserByEmail(user.getEmail())!=null){
            model.addAttribute("emailError","Error: Email already exists");
            model.addAttribute("citizen",new User());
            return "citizenForm";
        }
        else {
            user.setRoles(roleService.findRolesByName("Citizen"));
            userService.save(user);
            return "redirect:/apply";
        }
        /*
        try {
            user.setRoles(roleService.findRolesByName("Citizen"));
            userService.save(user);
            return "redirect:/apply";
        }
        catch ( ConstraintViolationException e) {
            model.addAttribute("emailError","Error: Email already exists");
            model.addAttribute("citizen",new User());
            return "citizenForm";
        }
         */
    }

    @RequestMapping("/apply")
    public String applicationPage(Model model, @CurrentSecurityContext(expression = "authentication.name") String email) {
        Application application = new Application();
        model.addAttribute("application", application);
        User user = userService.findUserByEmail(email);
        model.addAttribute("user",user);

        Application existingApp = applicationService.findApplicationByUserId(user.getId());
        if (existingApp != null) {
            model.addAttribute("emailError","Error: Email already exists");
            return "redirect:/apply/" + user.getId() + "/records";
        }

        return  "application";
    }


    @RequestMapping(method = RequestMethod.POST, path = "/apply/save")
    public String recordPage(@CurrentSecurityContext(expression = "authentication.name") String email,
                             @ModelAttribute Application application) {
        application.setUser(userService.findUserByEmail(email));
        Application savedApp = applicationService.save(application);
        return "redirect:/apply/records";
    }

    @RequestMapping("/apply/records")
    public String savedRecordPage(@CurrentSecurityContext(expression = "authentication.name") String email, Model model) {
        Application savedApp = applicationService.findApplicationByUserEmail(email);
        model.addAttribute("applications", savedApp);

        return "records";
    }


    @RequestMapping(value = "/status")
    public String savedApplicationDetails(@CurrentSecurityContext(expression = "authentication.name") String email, Model model) {
        Application savedCitizen = applicationService.findApplicationByUserEmail(email);

        if (savedCitizen==null) {
            return "redirect:/apply";
        }
        else
        model.addAttribute("applications", savedCitizen);
        return "records";

    }



}
