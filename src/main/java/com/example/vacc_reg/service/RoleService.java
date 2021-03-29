package com.example.vacc_reg.service;

import com.example.vacc_reg.model.Roles;

import java.util.HashSet;
import java.util.Set;

public interface RoleService extends CrudService<Roles,Long> {


    Roles findRolesByName(String roles);

}
