package com.example.vacc_reg.controller;

import com.example.vacc_reg.model.*;
import com.example.vacc_reg.service.ApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StatsController {

    ApplicationService applicationService;

    public StatsController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/admin/getGender")
    public List<Data> getData() {
        List<Data> genderList = new ArrayList<>();
        Long maleCount= applicationService.countApplicationsByGender(Gender.MALE);
        Long femaleCount = applicationService.countApplicationsByGender(Gender.FEMALE);
        genderList.add(new Data("male",maleCount));
        genderList.add(new Data("female", femaleCount));


        return genderList;
    }

    @GetMapping("/admin/getStatus")
    public List<Data> getStatusData() {
        List<Data> statusList = new ArrayList<>();
        Long vaccinated= applicationService.countApplicationsByStatus(Status.VACCINATED);
        Long not_vaccinated = applicationService.countApplicationsByStatus(Status.NOT_VACCINATED);
        statusList.add(new Data("vaccinated",vaccinated));
        statusList.add(new Data("not_vaccinated", not_vaccinated));


        return statusList;
    }



    /*
    @GetMapping("/admin/stateData")
    public List<StateList> getStateDetails() {

        List<StateList> list = new ArrayList<>();
        for (State n : State.values()){
            StateList stateList = new StateList();

            stateList.setName(n.name());
            stateList.setVaccinatedCount(applicationService.countApplicationsByStatusAndState(Status.VACCINATED, n));
            stateList.setNotVaccinatedCount(applicationService.countApplicationsByStatusAndState(Status.NOT_VACCINATED, n));
            stateList.setTotalApplication(applicationService.countApplicationsByState(n));

            list.add(stateList);
        }
        return list;
    }

     */
}
