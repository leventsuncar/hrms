package com.hrms.dataAccess.abstracts;

import com.hrms.entites.CVLanguages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVLanguageDao extends JpaRepository<CVLanguages,Integer> {
}
