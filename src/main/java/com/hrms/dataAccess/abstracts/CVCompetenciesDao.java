package com.hrms.dataAccess.abstracts;

import com.hrms.entites.CVCompetencies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVCompetenciesDao extends JpaRepository<CVCompetencies, Integer> {
}
