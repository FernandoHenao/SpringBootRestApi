package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person_of_interest")
public class PersonOfInterest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poiId", nullable = false, unique = true)
    private Long personOfInterestId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob_month")
    private int dobMonth;

    @Column(name = "dob_day")
    private int dobDay;

    @Column(name = "dob_year")
    private int dobYear;

    @Column(name = "ssn")
    private String ssn;

    @Column(name = "created_date")
    private LocalDateTime createdDate;



}