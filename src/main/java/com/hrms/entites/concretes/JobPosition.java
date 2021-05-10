package com.hrms.entites.concretes;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "job_position")

public class JobPosition {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", unique = true)//unique = true çalışmadı
    @NotNull
    private String name;
}
