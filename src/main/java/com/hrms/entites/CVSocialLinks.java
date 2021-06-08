package com.hrms.entites;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "social_links")
public class CVSocialLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "github_link")
    private String githubLink;

    @Column(name = "linkedin_link")
    private String linkedinLink;

    @OneToOne
    @JoinColumn(name = "job_seeker_cv_id")
    private JobSeekerCV jobSeekerCV;
}
