package com.hrms.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "job_seeker_cv")
public class JobSeekerCV {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "photoraph")
    private String photograph;

    @Column(name = "cover_letter")
    private String coverLetter;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;


    @OneToMany(mappedBy = "jobSeekerCV")
    private List<CVCompetencies> cvCompetencies;

    @OneToOne(mappedBy = "jobSeekerCV")
    private CVEducation cvEducation;

    @OneToMany(mappedBy = "jobSeekerCV")
    private List<CVExperience> cvExperiences;

    @OneToMany(mappedBy = "jobSeekerCV")
    private List<CVLanguages> cvLanguages;

    @OneToOne(mappedBy = "jobSeekerCV")
    private CVSocialLinks cvSocialLinks;
}
