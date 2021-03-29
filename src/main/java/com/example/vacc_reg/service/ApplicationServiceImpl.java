package com.example.vacc_reg.service;

import com.example.vacc_reg.model.Application;
import com.example.vacc_reg.model.Gender;
import com.example.vacc_reg.model.State;
import com.example.vacc_reg.model.User;
import com.example.vacc_reg.repository.ApplicationRepository;
import com.example.vacc_reg.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationRepository applicationRepository;

    private UserRepository userRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository, UserRepository userRepository) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Set<Application> findAll() {
        Set<Application> app = new HashSet<>();
        applicationRepository.findAll().forEach(app::add);
        return app;
    }

    @Override
    public Application findById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }

    @Override
    public Application save(Application object) {
        return applicationRepository.save(object);
    }

    @Override
    public void delete(Application object) {
        applicationRepository.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        applicationRepository.deleteById(id);
    }

    @Override
    public Application findByUser(User user) {

        return applicationRepository.findByUser(user).orElse(null);
    }

    @Override
    public Application findApplicationByUserId(Long id) {

        return applicationRepository.findApplicationByUserId(id).orElse(null);
    }

    @Override
    public Set<Application> findApplicationsByUserId(Long id) {
        return null;
    }

    @Override
    public Application findByUserEmail(String email) {
        return applicationRepository.findByUserEmail(email);
    }

    @Override
    public Application findByState(State state) {
        return applicationRepository.findByState(state).orElse(null);
    }

    @Override
    public List<Application> findByKeyword(String keyword) {
        return applicationRepository.findByKeyword(keyword);
    }

    @Override
    public Set<Application> findApplicationsByUserLastName(String lastName) {
        Set<Application> applicationSet= new HashSet<>();
        applicationRepository.findApplicationsByUserLastName(lastName).forEach(applicationSet::add);
        return applicationSet;
    }

    @Override
    public Application findApplicationByUserEmail(String email) {
        return applicationRepository.findApplicationByUserEmail(email).orElse(null);
    }

    @Override
    public Long countApplicationsByGender(Gender gender) {
        return applicationRepository.countApplicationsByGender(gender);
    }

    @Override
    public Long countApplicationsByState(State state) {
        return applicationRepository.countApplicationsByState(state);
    }
}
