package com.hrms.service.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.dto.EmployerDto;
import com.hrms.dto.JobSeekerDto;
import com.hrms.dto.SystemStaffDto;
import com.hrms.dto.UserDto;
import com.hrms.entites.User;

import java.util.List;

public interface UserService {

    DataResult<List<UserDto>> getAll();

    User addUserEmployer(EmployerDto employerDto);

    User addUserJobSeeker(JobSeekerDto jobSeekerDto);

    User  addUserSystemStaff(SystemStaffDto systemStaffDto);

}
