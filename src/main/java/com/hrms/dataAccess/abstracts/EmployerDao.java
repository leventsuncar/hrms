package com.hrms.dataAccess.abstracts;

import com.hrms.entites.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
}
