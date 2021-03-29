package com.example.vacc_reg.service;

import java.util.Set;

public interface CrudService<T, id> {
        Set<T> findAll();
        T findById(Long id);
        T save(T object);
        void delete(T object);
        void deleteById(Long id);

    }
