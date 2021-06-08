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

    @Column(name = "high_school_name")
    private String highSchoolName;

    @Column(name = "high_school_start_year")
    private int highSchoolStartYear;

    @Column(name = "high_school_end_year")
    private int highSchoolEndYear;

    @Column(name = "university_name")
    private String universityName;

    @Column(name = "university_department")
    private String universityDepartment;

    @Column(name = "university_start_year")
    private int universityStartYear;

    @Column(name = "university_end_year")
    private int universityEndYear;

    @ManyToOne
    @JoinColumn(name = "job_seeker_cv_id")
    private JobSeekerCV jobSeekerCV;

}
