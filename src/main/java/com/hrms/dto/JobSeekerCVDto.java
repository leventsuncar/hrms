package com.hrms.dto;

import java.util.List;

public class JobSeekerCVDto {

    private String jobSeekerFirstName;
    private String jobSeekerLastName;
    private String jobSeekerBirthYEar;
    private String photograph;
    private String coverLetter;
    private List<CVCompentenciesDto> cvCompentenciesDtoList;
    private CVEducationDto cvEducationDto;
    private List<CVExperienceDto> cvExperienceDtoList;
    private List<CVLanguageDto> cvLanguageDtoList;
    private CVSocialLinkDto cvSocialLinkDto;

}
