package com.hrms.service.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.dto.JobSeekerDto;

import java.util.List;

public interface JobSeekerService {

    DataResult<List<JobSeekerDto>> getAll();

    Result add(JobSeekerDto jobSeekerDto) throws Exception;
}
