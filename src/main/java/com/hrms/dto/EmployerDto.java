package com.hrms.dto;

import lombok.Data;

//Employer entity'sinde bir join var employer eklemek için sanırım böyle bir yapı lazım.
@Data
public class EmployerDto {


    private String companyName;
    private String website;
    private Long telephoneNumber;
    private String email; //Employer entity'sinde böyle bir bilgi yok
    private String password;
}
