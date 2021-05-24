package com.hrms.dto;

import lombok.Data;

//Data Transfer Object'lerde başka bir anotasyona gerek yok bildiğim kadarıyla
@Data
public class JobPositionDto {

    private int id;
    private String name;

}
