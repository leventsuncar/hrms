package com.hrms.entites.concretes;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "employer")
public class Employer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "company_name", unique = true)
    @NotNull
    private String companyName;

    @Column(name = "website", unique = true)
    @NotNull
    private String website;

    @Column(name = "telephone_number", length = 11, unique = true)
    @NotNull
    private Long telephoneNumber;

    @OneToOne
    @NotNull
    private BaseUser baseUser;
}
