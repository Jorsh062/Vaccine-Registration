package com.example.vacc_reg.repository;

import com.example.vacc_reg.model.Application;
import com.example.vacc_reg.model.Gender;
import com.example.vacc_reg.model.State;
import com.example.vacc_reg.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long> {
    Optional<Application> findApplicationByUserId(Long id);

    Optional<Application> findByUser(User user);

    Set<Application> findApplicationsByUserId(Long id);

    Application findByUserEmail(String email);

    Optional<Application> findByState(State state);

    @Query(value = "SELECT * FROM application WHERE e.user.firstName LIKE %:keyword%  OR e.user.lastName LIKE %:keyword%", nativeQuery = true)
    List<Application> findByKeyword(@Param("keyword") String keyword);

    Set<Application> findApplicationsByUserLastName(String lastName);

    Optional<Application> findApplicationByUserEmail(String email);

    Long countApplicationsByGender(Gender gender);

    Long countApplicationsByState(State state);

    //Application countApplicationsByVaccinationDate();


}
