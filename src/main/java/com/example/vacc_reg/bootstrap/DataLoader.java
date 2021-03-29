package com.example.vacc_reg.bootstrap;

import com.example.vacc_reg.model.Roles;
import com.example.vacc_reg.model.User;
import com.example.vacc_reg.repository.UserRepository;
import com.example.vacc_reg.service.RoleService;
import com.example.vacc_reg.service.RoleServiceImpl;
import com.example.vacc_reg.service.UserService;
import com.example.vacc_reg.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {



    private UserRepository userRepository;
    private UserService userService;
    private RoleService roleService;

    public DataLoader(UserRepository userRepository, UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.roleService = roleService;
    }



    @Override
    public void run(String... args) throws Exception {

        if(userService.findAll().isEmpty()) {
            Roles admin = new Roles(1L,"Admin");
            Roles roles = new Roles( 2L,"Health");
            Roles roles1 = new Roles(3L,"Citizen");


            User user = User.builder().email("admin@gmail.com").password("admin123").firstName("Maxwell")
                    .lastName("Joe").roles(roleService.save(admin)).build();
            userService.save(user);

            User user1 = User.builder().email("health@test.com").password("health123").firstName("John")
                    .lastName("Mark").roles(roleService.save(roles)).build();
            userService.save(user1);

            User user2 = User.builder().email("citizen@test.com").password("citizen123").firstName("Mark")
                    .lastName("Robbins").roles(roleService.save(roles1)).build();
            userService.save(user2);
        }
    }
}
