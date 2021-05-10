package com.hrms.service.concretes;

import com.hrms.dataAccess.abstracts.JobPositionDao;
import com.hrms.entites.concretes.JobPosition;
import com.hrms.service.abstracts.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobPositionManager implements JobPositionService {


    JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public List<JobPosition> getAll() {
        return jobPositionDao.findAll();
    }
    @Override
    public JobPosition add(JobPosition jobPosition) {
       return jobPositionDao.save(jobPosition);
    }
}

