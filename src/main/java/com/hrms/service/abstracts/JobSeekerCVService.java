package com.hrms.service.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.dto.JobSeekerCVDto;

import java.util.List;

public interface JobSeekerCVService {

    DataResult<List<JobSeekerCVDto>> getAll();
    Result add(JobSeekerCVDto jobSeekerCVDto);
    DataResult<List<JobSeekerCVDto>> sortedByExperienceYearAndEducationEndYear();



}
