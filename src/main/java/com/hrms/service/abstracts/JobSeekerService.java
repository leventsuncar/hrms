package com.hrms.service.abstracts;

import com.hrms.dto.JobSeekerDto;
import com.hrms.entites.JobSeeker;

import java.util.List;

public interface JobSeekerService {
    List<JobSeekerDto> getAll();

    JobSeeker add(JobSeekerDto jobSeekerDto) throws Exception;
}
