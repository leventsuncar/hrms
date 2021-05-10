package com.hrms.entites.concretes;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "system_staff")
public class SystemStaff {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_name",unique = true)
    @NotNull
    private String userName;

    @OneToOne
    @JoinColumn(name = "staff_user_id")
    private BaseUser user;
}
