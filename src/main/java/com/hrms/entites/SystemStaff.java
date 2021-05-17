package com.hrms.entites;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "system_staffs")
public class SystemStaff {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_name", unique = true, nullable = false)
    @NotNull
    private String userName;

    @OneToOne
    private User userSystemStaff;

}
