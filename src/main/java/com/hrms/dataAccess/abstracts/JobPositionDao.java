package com.hrms.dataAccess.abstracts;

import com.hrms.entites.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {
}