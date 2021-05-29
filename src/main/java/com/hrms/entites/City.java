package com.hrms.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "cities")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisement"})
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(mappedBy = "city")
    private List<JobAdvertisement> jobAdvertisement;
}
