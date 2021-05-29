package com.hrms.entites;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement"})
public class JobPosition {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    @NotNull
    private String name;

    @OneToMany (mappedBy = "jobPosition")
    private List<JobAdvertisement> jobAdvertisement;
}
