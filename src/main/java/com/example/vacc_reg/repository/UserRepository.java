package com.example.vacc_reg.repository;

import com.example.vacc_reg.model.Roles;
import com.example.vacc_reg.model.User;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;
import java.util.Set;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    Set<User> findUsersByRoles(Roles roles);
}
