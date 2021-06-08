package com.hrms.dataAccess.abstracts;

import com.hrms.entites.CVExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVExperienceDao extends JpaRepository<CVExperience,Integer> {
}
