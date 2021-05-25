package com.hrms.service.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.dto.JobPositionDto;

import java.util.List;

public interface JobPositionService {

    DataResult<List<JobPositionDto>> getAll();

    Result add(JobPositionDto jobPosition);
}
