package com.hrms.entites;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "competencies")
public class CVCompetencies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "technology")
    private String technology;

    @Column(name = "codding_language")
    private String codingLanguage;

    @ManyToOne
    @JoinColumn(name = "job_seeker_cv_id")
    private JobSeekerCV jobSeekerCV;

}
