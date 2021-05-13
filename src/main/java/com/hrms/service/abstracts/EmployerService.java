package com.hrms.service.abstracts;

import com.hrms.entites.Employer;

import java.util.List;

public interface EmployerService {

    void add(Employer employer);

    List<Employer> getAll();

    void delete(Employer employer);

    void update(Employer employer);

}
