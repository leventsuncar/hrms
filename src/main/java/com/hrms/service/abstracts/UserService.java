package com.hrms.service.abstracts;

import com.hrms.dto.EmployerDto;
import com.hrms.dto.UserDto;
import com.hrms.entites.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();
    User add(EmployerDto employerDto);

}
