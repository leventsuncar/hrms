package com.hrms.dto;

import lombok.Data;

@Data
public class JobSeekerDto {

    private int id;
    private String firstName;
    private String lastName;
    private Long nationalId;
    private int birthYear;
    private String email;
    private String password;

}
