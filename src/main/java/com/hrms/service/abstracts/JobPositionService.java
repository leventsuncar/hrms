package com.hrms.service.abstracts;

import com.hrms.dto.JobPositionDto;
import com.hrms.entites.JobPosition;

import java.util.List;

public interface JobPositionService {
    List<JobPositionDto> getAll();

    JobPosition add(JobPosition jobPosition);
}
