package com.hrms.service.abstracts;

import com.hrms.dto.SystemStaffDto;
import com.hrms.entites.SystemStaff;
import com.hrms.entites.User;

import java.util.List;

public interface SystemStaffService {

    SystemStaff add(SystemStaffDto systemStaffDto, User user);

    List<SystemStaffDto> getAll();

}
