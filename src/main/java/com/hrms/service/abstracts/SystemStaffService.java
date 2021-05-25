package com.hrms.service.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.dto.SystemStaffDto;

import java.util.List;

public interface SystemStaffService {

    Result add(SystemStaffDto systemStaffDto);

    DataResult<List<SystemStaffDto>> getAll();

}
