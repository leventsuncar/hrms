package com.hrms.service.concretes;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
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
    public DataResult<List<JobPositionDto>> getAll() {
        List<JobPosition> jobPositionList = jobPositionDao.findAll();
        return new SuccessDataResult<List<JobPositionDto>>(jobPositionList.stream().map(jobPosition ->
                modelMapper.map(jobPosition, JobPositionDto.class)).collect(Collectors.toList()));
    }

    @Override
    public Result add(JobPositionDto jobPosition) {
        //Tekrarlama kontrolü database de.

        JobPosition position = modelMapper.map(jobPosition, JobPosition.class);
        jobPositionDao.save(position);
        return new SuccessResult("İş pozisyonu eklendi");
    }
}

