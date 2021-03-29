package com.example.vacc_reg.service;

import com.example.vacc_reg.model.Application;
import com.example.vacc_reg.model.Gender;
import com.example.vacc_reg.model.State;
import com.example.vacc_reg.model.User;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ApplicationService extends CrudService<Application, Long> {
    Application findByUser(User user);

    Application findApplicationByUserId(Long id);

    Set<Application> findApplicationsByUserId(Long id);

    Application findByUserEmail(String email);

    Application findByState(State state);

    List<Application> findByKeyword(@Param("keyword") String keyword);

    Set<Application> findApplicationsByUserLastName(String lastName);

    Application findApplicationByUserEmail(String email);

    Long countApplicationsByGender(Gender gender);

    Long countApplicationsByState(State state);



}
