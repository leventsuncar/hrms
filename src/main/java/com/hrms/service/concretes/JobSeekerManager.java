package com.hrms.service.concretes;

import com.hrms.core.adapter.mernisAdapter.abstracts.MernisAdapterService;
import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.JobSeekerCVDao;
import com.hrms.dataAccess.abstracts.JobSeekerDao;
import com.hrms.dto.JobSeekerCVDto;
import com.hrms.dto.JobSeekerDto;
import com.hrms.entites.JobSeeker;
import com.hrms.entites.JobSeekerCV;
import com.hrms.entites.User;
import com.hrms.service.abstracts.JobSeekerService;
import com.hrms.service.abstracts.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobSeekerManager implements JobSeekerService {

    private MernisAdapterService mernisAdapterService;
    private JobSeekerDao jobSeekerDao;
    private ModelMapper modelMapper;
    private UserService userService;
    private JobSeekerCVDao jobSeekerCVDao;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, JobSeekerCVDao jobSeekerCVDao, UserService userService, ModelMapper modelMapper, MernisAdapterService mernisAdapterService) {
        this.jobSeekerDao = jobSeekerDao;
        this.modelMapper = modelMapper;
        this.mernisAdapterService = mernisAdapterService;
        this.userService = userService;
        this.jobSeekerCVDao = jobSeekerCVDao;
    }

    @Override
    public DataResult<List<JobSeekerDto>> getAll() {
        List<JobSeeker> jobSeekerList = jobSeekerDao.findAll();

        List<JobSeekerDto> jobSeekerDtoList = new ArrayList<>();
        for (JobSeeker jobSeeker : jobSeekerList) {

            JobSeekerDto jobSeekerDto = modelMapper.map(jobSeeker, JobSeekerDto.class);

            jobSeekerDtoList.add(jobSeekerDto);
        }
        return new SuccessDataResult<List<JobSeekerDto>>(jobSeekerDtoList);
//        return new SuccessDataResult<List<JobSeekerDto>>(jobSeekerList.stream().map(jobSeeker -> modelMapper.map(jobSeeker,
//                JobSeekerDto.class)).collect(Collectors.toList()));
    }

    @Override
    public Result add(JobSeekerDto jobSeekerDto) throws Exception {

        if (jobSeekerDto.getPassword().equals(jobSeekerDto.getConfirmPassword())) {
            //??nce girilen ??ifreleri kontrol ediyorum
            Boolean status = mernisAdapterService.verifyNationalId(jobSeekerDto);
            //mernis sonucunu status adl?? de??i??kene at??yorum
            if (status) {
                //mernis do??rulamas?? ba??ar??l?? ise(true)
                User user = userService.addUserJobSeeker(jobSeekerDto);
                //user servicedeki ilgili metodu ??a????rarak user olu??turuyorum
                JobSeeker jobSeeker = modelMapper.map(jobSeekerDto, JobSeeker.class);
                //dto yu entity ye ??eviriyorum
                jobSeeker.setUserJobSeeker(user);
                //entitydeki user alan??na burada olu??turdu??um user ?? ekliyorum
                jobSeekerDao.save(jobSeeker);
                //i?? arayan nesnesini kaydediyorum
                return new SuccessResult("???? arayan ba??ar??yla eklendi");
            } else {
                return new ErrorResult
                        ("Kimlik do??rulamas?? ba??ar??s??z oldu l??tfen bilgilerinizi kontrol ediniz");
            }
        } else {
            return new ErrorResult("Girilen ??ifreler uyu??muyor");
        }
    }
}
