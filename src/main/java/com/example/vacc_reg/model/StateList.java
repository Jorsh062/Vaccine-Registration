package com.example.vacc_reg.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class StateList {

    private String name;

    private Long vaccinatedCount;

    private Long notVaccinatedCount;

    private Long totalApplication;

    public Long getTotalApplication() {
        return totalApplication;
    }

    public void setTotalApplication(Long totalApplication) {
        this.totalApplication = totalApplication;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVaccinatedCount() {
        return vaccinatedCount;
    }

    public void setVaccinatedCount(Long vaccinatedCount) {
        this.vaccinatedCount = vaccinatedCount;
    }

    public Long getNotVaccinatedCount() {
        return notVaccinatedCount;
    }

    public void setNotVaccinatedCount(Long notVaccinatedCount) {
        this.notVaccinatedCount = notVaccinatedCount;
    }
}
