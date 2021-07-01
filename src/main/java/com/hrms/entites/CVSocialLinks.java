package com.hrms.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "social_links")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "job_seeker_cv"})
public class CVSocialLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "github_link")
    private String githubLink;

    @Column(name = "linkedin_link")
    private String linkedinLink;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "job_seeker_cv_id")
    private JobSeekerCV jobSeekerCV;
}
