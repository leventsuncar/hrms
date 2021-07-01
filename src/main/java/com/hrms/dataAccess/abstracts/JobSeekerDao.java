package com.hrms.dataAccess.abstracts;

import com.hrms.entites.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

    JobSeeker findByUserJobSeeker_Email(String email);
    JobSeeker findById(int id);
    JobSeeker findByNationalId(Long nationalId);

}
