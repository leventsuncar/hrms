package com.hrms.dataAccess.abstracts;

import com.hrms.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
