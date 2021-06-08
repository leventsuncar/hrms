package com.hrms.dto;

import lombok.Data;

@Data
public class CVEducationDto {


    private String highSchoolName;
    private int highSchoolStartYear;
    private int highSchoolEndYear;
    private String universityName;
    private String universityDepartment;
    private int universityStartYear;
    private int universityEndYear;

}
