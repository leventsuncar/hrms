package com.hrms.service.abstracts;

import com.hrms.entites.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    List<JobPosition> getAll();
    JobPosition add(JobPosition jobPosition);
}
