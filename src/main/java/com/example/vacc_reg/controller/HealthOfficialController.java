package com.example.vacc_reg.controller;

import com.example.vacc_reg.model.Application;
import com.example.vacc_reg.model.Status;
import com.example.vacc_reg.model.User;
import com.example.vacc_reg.service.ApplicationService;
import com.example.vacc_reg.service.ApplicationServiceImpl;
import com.example.vacc_reg.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@Controller
public class HealthOfficialController {

    private UserService userService;
    private ApplicationService applicationService;

    public HealthOfficialController(UserService userService, ApplicationServiceImpl applicationService) {
        this.userService = userService;
        this.applicationService = applicationService;
    }

    @GetMapping("/verify")
    public String showAllApplications(Model model) {
        Set<Application> appSet = applicationService.findAll();
        model.addAttribute("applications", appSet);

        User searchUser = new User();
        model.addAttribute("search",searchUser);
        return "officials/list";
    }

    @PostMapping("/verify")
    public String findApplicationsbyLastName(@ModelAttribute User user, Model model){
        if (user.getLastName()==null) {
            return "redirect:/verify";
        }
        else {
            Set<Application> appSet = applicationService.findApplicationsByUserLastName(user.getLastName());
            model.addAttribute("applications", appSet);

            Application searchApplication = new Application();
            model.addAttribute("search",searchApplication);

            return "officials/list";
        }

    }


    @GetMapping("/verify/{applicationId}")
    public String updatedFormStatus(@PathVariable String applicationId) {
        Application app = applicationService.findById(Long.valueOf(applicationId));

        app.setStatus(Status.VACCINATED);
        applicationService.save(app);

        return "redirect:/verify";
    }
}
