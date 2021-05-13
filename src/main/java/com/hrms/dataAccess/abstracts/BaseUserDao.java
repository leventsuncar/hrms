package com.hrms.dataAccess.abstracts;

import com.hrms.entites.concretes.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseUserDao extends JpaRepository<Login,Integer> {
}
