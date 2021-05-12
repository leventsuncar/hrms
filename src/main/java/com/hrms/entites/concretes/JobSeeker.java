package com.hrms.entites.concretes;

import com.sun.istack.NotNull;
import lombok.Data;


import javax.persistence.*;

@Entity
@Data
@Table(name = "job_seeker")

public class JobSeeker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    @NotNull
    private String firsName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column(name = "national_id", length = 11)
    @NotNull
    private Long nationalId;

    @Column(name = "birth_year", length = 4)
    @NotNull
    private int birthYear;


}
