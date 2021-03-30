package com.example.vacc_reg.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Past;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vaccinationDate")
    private String VaccinationDate;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    //@Past(message = "invalid date of birth")
    @Column(name = "dateOfBirth")
    private String dateOfBirth;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @Lob
    @Column(name = "residentialAddress")
    private String residentialAddress;

    //@Column(name = "state")
    //private String state;

    @Column(name = "lga")
    private String lga;

    @Enumerated(value = EnumType.STRING)
    private Id_type id_type;


    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @Enumerated(value = EnumType.STRING)
    private Status status= Status.NOT_VACCINATED;

}

