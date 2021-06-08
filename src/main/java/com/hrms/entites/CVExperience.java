package com.hrms.entites;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "experinces")
public class CVExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "job_position")
    private String jobPosition;

    @Column(name = "start_year")
    private int startYear;

    @Column(name = "end_year")
    private int endYear;

    @ManyToOne
    @JoinColumn(name = "job_seeker_cv_id")
    private JobSeekerCV jobSeekerCV;

}
