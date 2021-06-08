package com.hrms.dataAccess.abstracts;

import com.hrms.entites.CVEducation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVEducationDao extends JpaRepository<CVEducation, Integer> {
}
