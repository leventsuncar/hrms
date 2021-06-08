package com.hrms.entites;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "languages")
public class CVLanguages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "language")
    private String language;

    @Column(name = "level")
    private String level;

    @ManyToOne
    @JoinColumn(name = "job_seeker_cv_id")
    private JobSeekerCV jobSeekerCV;

}
