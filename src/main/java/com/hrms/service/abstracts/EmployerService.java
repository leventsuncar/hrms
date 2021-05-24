package com.hrms.service.abstracts;

import com.hrms.dto.EmployerDto;
import com.hrms.entites.Employer;

import java.util.List;

public interface EmployerService {

    Employer add(EmployerDto employerDto);

    List<EmployerDto> getAll();

    void delete(Employer employer);

    void update(Employer employer);

}
