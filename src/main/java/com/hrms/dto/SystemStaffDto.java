package com.hrms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("System Staff Data Transfer Object")
public class SystemStaffDto {

    @ApiModelProperty(required = true, value = "Username")
    private String userName;
    @ApiModelProperty(required = true, value = "Email")
    private String email;
    @ApiModelProperty(required = true, value = "Password")
    private String password;
    @ApiModelProperty(required = true, value = "Confirm Password")
    private String confirmPassword;

}
