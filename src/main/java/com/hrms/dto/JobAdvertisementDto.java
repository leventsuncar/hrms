package com.hrms.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class JobAdvertisementDto {

    private int id;
    private String jobDescription;
    private String cityName;
    private Integer salary;
    private Integer openPosition;
    private LocalDate applicationDeadline;
    private LocalDateTime createdAt;
    private String jobPositionName;
    private String employerCompanyName;


}
