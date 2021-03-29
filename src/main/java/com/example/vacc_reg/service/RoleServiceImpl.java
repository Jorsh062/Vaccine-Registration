package com.example.vacc_reg.service;

import com.example.vacc_reg.model.Roles;
import com.example.vacc_reg.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Roles> findAll() {
        Set<com.example.vacc_reg.model.Roles> roles = new HashSet<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    @Override
    public Roles findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Roles save(Roles object) {
        return roleRepository.save(object);
    }

    @Override
    public void delete(Roles object) {
        roleRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);

    }

    @Override
    public Roles findRolesByName(String roles) {
        return roleRepository.findRolesByName(roles);
    }
}
