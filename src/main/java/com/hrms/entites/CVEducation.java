package com.hrms.entites;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "educations")
public class CVEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "university_department")
    private String universityDepartment;

    @Column(name = "start_year")
    private int startYear;

    @Column(name = "end_year")
    private int endYear;

    @ManyToOne
    @JoinColumn(name = "job_seeker_cv_id")
    private JobSeekerCV jobSeekerCV;

}
