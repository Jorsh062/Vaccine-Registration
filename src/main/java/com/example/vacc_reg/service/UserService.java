package com.example.vacc_reg.service;

import com.example.vacc_reg.model.Roles;
import com.example.vacc_reg.model.User;

import java.util.Set;


public interface UserService extends CrudService<User, Long> {
    User findUserByEmail(String email);

    Set<User> findUsersByRoles(Roles roles);




}
