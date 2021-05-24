package com.hrms.service.abstracts;

import com.hrms.dto.SystemStaffDto;
import com.hrms.entites.SystemStaff;

import java.util.List;

public interface SystemStaffService {

    SystemStaff add(SystemStaffDto systemStaffDto);

    List<SystemStaffDto> getAll();

}
