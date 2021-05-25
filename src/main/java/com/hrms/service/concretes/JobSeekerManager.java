package com.hrms.service.concretes;

import com.hrms.core.adapter.mernisAdapter.abstracts.MernisAdapterService;
import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.JobSeekerDao;
import com.hrms.dto.JobSeekerDto;
import com.hrms.entites.JobSeeker;
import com.hrms.entites.User;
import com.hrms.service.abstracts.JobSeekerService;
import com.hrms.service.abstracts.UserService;
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
    private UserService userService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, UserService userService, ModelMapper modelMapper, MernisAdapterService mernisAdapterService) {
        this.jobSeekerDao = jobSeekerDao;
        this.modelMapper = modelMapper;
        this.mernisAdapterService = mernisAdapterService;
        this.userService = userService;
    }

    @Override
    public DataResult<List<JobSeekerDto>> getAll() {
        List<JobSeeker> jobSeekerList = jobSeekerDao.findAll();
        return new SuccessDataResult<List<JobSeekerDto>>(jobSeekerList.stream().map(jobSeeker -> modelMapper.map(jobSeeker,
                JobSeekerDto.class)).collect(Collectors.toList()));
    }

    @Override
    public Result add(JobSeekerDto jobSeekerDto) throws Exception {

        if (jobSeekerDto.getPassword().equals(jobSeekerDto.getConfirmPassword())) {
            //Önce girilen şifreleri kontrol ediyorum
            Boolean status = mernisAdapterService.verifyNationalId(jobSeekerDto);
            //mernis sonucunu status adlı değişkene atıyorum
            if (status) {
                //mernis doğrulaması başarılı ise(true)
                User user = userService.addUserJobSeeker(jobSeekerDto);
                //user servicedeki ilgili metodu çağırarak user oluşturuyorum
                JobSeeker jobSeeker = modelMapper.map(jobSeekerDto, JobSeeker.class);
                //dto yu entity ye çeviriyorum
                jobSeeker.setUserJobSeeker(user);
                //entitydeki user alanına burada oluşturduğum user ı ekliyorum
                jobSeekerDao.save(jobSeeker);
                //iş arayan nesnesini kaydediyorum
                return new SuccessResult("İş arayan başarıyla eklendi");
            } else {
                return new ErrorResult
                        ("Kimlik doğrulaması başarısız oldu lütfen bilgilerinizi kontrol ediniz");
            }
        } else {
            return new ErrorResult("Girilen şifreler uyuşmuyor");
        }
    }
}
