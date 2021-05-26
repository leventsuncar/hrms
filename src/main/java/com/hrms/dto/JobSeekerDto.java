package com.hrms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Job Seeker Data Transfer Object")
public class JobSeekerDto {

    @ApiModelProperty(required = true, value = "First Name")
    private String firstName;
    @ApiModelProperty(required = true, value = "Last Name")
    private String lastName;
    @ApiModelProperty(required = true, value = "National Identification Number")
    private Long nationalId;
    @ApiModelProperty(required = true, value = "Birth Year")
    private int birthYear;
    @ApiModelProperty(required = true, value = "Email")
    private String email;
    @ApiModelProperty(required = true, value = "Password")
    private String password;
    @ApiModelProperty(required = true, value = "Confirm Password")
    private String confirmPassword;


}
