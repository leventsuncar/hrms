package com.hrms.service.concretes;

import com.hrms.dataAccess.abstracts.JobPositionDao;
import com.hrms.dto.JobPositionDto;
import com.hrms.entites.JobPosition;
import com.hrms.service.abstracts.JobPositionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobPositionManager implements JobPositionService {


    JobPositionDao jobPositionDao;
    ModelMapper modelMapper;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao, ModelMapper modelMapper) {
        this.jobPositionDao = jobPositionDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<JobPositionDto> getAll() {
        List<JobPosition> jobPositionList = jobPositionDao.findAll();
        return jobPositionList.stream().map(jobPosition -> modelMapper.map(jobPosition, JobPositionDto.class)).collect(Collectors.toList());
    }

    @Override
    public JobPosition add(JobPosition jobPosition) {
        return jobPositionDao.save(jobPosition);
    }
}

