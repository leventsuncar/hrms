package com.hrms.service.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.dto.EmployerDto;
import com.hrms.entites.Employer;

import java.util.List;

public interface EmployerService {

    Result add(EmployerDto employerDto) throws Exception;

    DataResult<List<EmployerDto>> getAll();

    Result delete(Employer employer);

    Result update(Employer employer);

}
