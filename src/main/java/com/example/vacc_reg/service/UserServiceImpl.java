package com.example.vacc_reg.service;

import com.example.vacc_reg.model.Roles;
import com.example.vacc_reg.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl  implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.example.vacc_reg.model.User user = userRepository.findUserByEmail(s).orElse(null);
        if (user==null) {
            throw new UsernameNotFoundException("Username not found");
        }
        UserDetails userDetails = User.builder().username(user.getEmail()).password(user.getPassword()).authorities(user.getRoles().getName()).build();
        return userDetails;
    }

    @Override
    public Set<com.example.vacc_reg.model.User> findAll() {
        Set<com.example.vacc_reg.model.User> users = new HashSet<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public com.example.vacc_reg.model.User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public com.example.vacc_reg.model.User save(com.example.vacc_reg.model.User object) {
        object.setPassword(passwordEncoder().encode(object.getPassword()));
        return userRepository.save(object);
    }

    @Override
    public void delete(com.example.vacc_reg.model.User object) {

    }

    @Override
    public void deleteById(Long id) {

    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public com.example.vacc_reg.model.User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElse(null);
    }

    @Override
    public Set<com.example.vacc_reg.model.User> findUsersByRoles(Roles roles) {
        return userRepository.findUsersByRoles(roles);
    }

}

