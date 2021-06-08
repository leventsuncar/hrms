package com.hrms.entites;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "job_seekers")

public class JobSeeker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name", nullable = false)
    @NotNull
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotNull
    private String lastName;

    @Column(name = "national_id", length = 11, unique = true, nullable = false)
    @NotNull
    private Long nationalId;

    @Column(name = "birth_year", length = 4, nullable = false)
    @NotNull
    private int birthYear;

    @OneToOne
    private User userJobSeeker;

    @OneToOne(mappedBy = "jobSeeker")
    private JobSeekerCV jobSeekerCV;

}
