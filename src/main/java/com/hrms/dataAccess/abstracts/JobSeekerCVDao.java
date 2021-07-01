package com.hrms.dataAccess.abstracts;

import com.hrms.entites.JobSeeker;
import com.hrms.entites.JobSeekerCV;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerCVDao extends JpaRepository<JobSeekerCV, Integer> {
    JobSeekerCV findByJobSeeker(JobSeeker jobSeeker);
}
