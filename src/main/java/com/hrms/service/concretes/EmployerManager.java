package com.hrms.service.concretes;

import com.hrms.dataAccess.abstracts.BaseUserDao;
import com.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.entites.concretes.Employer;
import com.hrms.service.abstracts.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployerManager implements EmployerService {

    private BaseUserDao baseUserDao;
    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(BaseUserDao baseUserDao, EmployerDao employerDao) {
        this.baseUserDao = baseUserDao;
        this.employerDao = employerDao;
    }

    @Override
    public void add(Employer employer) {

        employerDao.save(employer);
    }

    @Override
    public List<Employer> getAll() {

        return employerDao.findAll();
    }

    @Override
    public void delete(Employer employer) {

    }

    @Override
    public void update(Employer employer) {

    }
}
