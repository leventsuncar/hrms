package com.hrms.service.concretes;

import com.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.entites.Employer;
import com.hrms.service.abstracts.EmployerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    @Autowired
    private EmployerDao employerDao;        //Field injection is no recommended

    @Autowired
    private ModelMapper modelMapper;        //Field injection önerilmez constructorla yapılacak


    @Override
    public void add(Employer employer) {
        //sanırım burada Login Dao da çağırılmalı bunu nasıl yapacağımı bilmiyorum
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
