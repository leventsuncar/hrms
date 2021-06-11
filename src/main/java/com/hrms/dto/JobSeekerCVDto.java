package com.hrms.dto;

import lombok.Data;

import java.util.List;
@Data
public class JobSeekerCVDto {

    private String jobSeekerFirstName;
    private String jobSeekerLastName;
    private int jobSeekerBirthYear;
    private String photograph;
    private String coverLetter;
    private List<CVCompentenciesDto> cvCompentenciesDtoList;
    private CVEducationDto cvEducationDto;
    private List<CVExperienceDto> cvExperienceDtoList;
    private List<CVLanguageDto> cvLanguageDtoList;
    private CVSocialLinkDto cvSocialLinkDto;
    private String email;

}
