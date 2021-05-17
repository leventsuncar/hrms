package com.hrms.service.concretes;

import com.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.dto.EmployerDto;
import com.hrms.entites.Employer;
import com.hrms.entites.User;
import com.hrms.service.abstracts.EmployerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployerManager implements EmployerService {

    @Autowired
    private EmployerDao employerDao;        //Field injection is no recommended

    @Autowired
    private ModelMapper modelMapper;        //Field injection önerilmez constructorla yapılacak


    @Override
    public Employer add(EmployerDto employerDto, User user) {
        Employer employer = modelMapper.map(employerDto, Employer.class);
        employer.setUserEmployer(user);

        return employerDao.save(employer);
    }

    @Override
    public List<EmployerDto> getAll() {

        List<Employer> employerList = employerDao.findAll();

        return employerList.stream().map(employer -> modelMapper.map(employer,
                EmployerDto.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Employer employer) {

    }

    @Override
    public void update(Employer employer) {

    }
}
