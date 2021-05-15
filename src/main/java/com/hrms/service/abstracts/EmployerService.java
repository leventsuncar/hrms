package com.hrms.service.abstracts;

import com.hrms.dto.EmployerDto;
import com.hrms.entites.Employer;
import com.hrms.entites.User;

import java.util.List;

public interface EmployerService {

    Employer add(EmployerDto employerDto, User user);

    List<EmployerDto> getAll();

    void delete(Employer employer);

    void update(Employer employer);

}
