package com.hrms.service.concretes;

import com.hrms.adapter.mernisAdapter.abstracts.MernisAdapterService;
import com.hrms.dataAccess.abstracts.JobSeekerDao;
import com.hrms.dto.JobSeekerDto;
import com.hrms.entites.JobSeeker;
import com.hrms.entites.User;
import com.hrms.mernis.CJEKPSPublicSoap;
import com.hrms.service.abstracts.JobSeekerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobSeekerManager implements JobSeekerService {

    private MernisAdapterService mernisAdapterService;
    private JobSeekerDao jobSeekerDao;
    private ModelMapper modelMapper;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, ModelMapper modelMapper, MernisAdapterService mernisAdapterService) {
        this.jobSeekerDao = jobSeekerDao;
        this.modelMapper = modelMapper;
        this.mernisAdapterService = mernisAdapterService;
    }

    @Override
    public List<JobSeekerDto> getAll() {
        List<JobSeeker> jobSeekerList = jobSeekerDao.findAll();
        return jobSeekerList.stream().map(jobSeeker -> modelMapper.map(jobSeeker,
                JobSeekerDto.class)).collect(Collectors.toList());
    }

    @Override
    public JobSeeker add(JobSeekerDto jobSeekerDto, User user) throws Exception {
        Boolean status = mernisAdapterService.verifyNationalId(jobSeekerDto);
        if (status) {
            JobSeeker jobSeeker = modelMapper.map(jobSeekerDto, JobSeeker.class);
            jobSeeker.setUserJobSeeker(user);
            return jobSeekerDao.save(jobSeeker);
        } else {
            throw new IllegalArgumentException("Hatalı bilgi");
        }

    }
}
