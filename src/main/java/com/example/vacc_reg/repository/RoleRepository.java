package com.example.vacc_reg.repository;

import com.example.vacc_reg.model.Roles;

import org.springframework.data.repository.CrudRepository;




public interface RoleRepository extends CrudRepository<Roles, Long> {
    Roles findRolesByName(String roles);

}
