package com.hrms.dataAccess.abstracts;

import com.hrms.entites.concretes.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseUserDao extends JpaRepository<BaseUser,Integer> {
}
