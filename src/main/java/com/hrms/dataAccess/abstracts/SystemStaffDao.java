package com.hrms.dataAccess.abstracts;

import com.hrms.entites.concretes.SystemStaff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemStaffDao extends JpaRepository<SystemStaff,Integer> {
}
