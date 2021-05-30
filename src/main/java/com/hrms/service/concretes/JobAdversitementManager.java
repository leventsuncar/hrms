package com.hrms.service.concretes;

import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.CityDao;
import com.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.hrms.dataAccess.abstracts.JobPositionDao;
import com.hrms.dto.JobAdvertisementDto;
import com.hrms.entites.City;
import com.hrms.entites.Employer;
import com.hrms.entites.JobAdvertisement;
import com.hrms.entites.JobPosition;
import com.hrms.service.abstracts.JobAdversitementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobAdversitementManager implements JobAdversitementService {

    @Autowired
    private JobAdvertisementDao jobAdvertisementDao;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmployerDao employerDao;
    @Autowired
    private JobPositionDao jobPositionDao;
    @Autowired
    private CityDao cityDao;


    @Override
    public DataResult<List<JobAdvertisementDto>> getAll() {

        List<JobAdvertisement> jobAdvertisementList = jobAdvertisementDao.findAll();

        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementList.stream()
                .map(jobAdvertisement -> modelMapper.map(jobAdvertisement, JobAdvertisementDto.class))
                .collect(Collectors.toList()));
    }

    @Override
    public Result add(JobAdvertisementDto jobAdvertisementDto) {
        try {
            Employer employer = employerDao.findByCompanyName(jobAdvertisementDto.getEmployerCompanyName());
            City city = cityDao.findByName(jobAdvertisementDto.getCityName());
            JobPosition jobPosition = jobPositionDao.findByName(jobAdvertisementDto.getJobPositionName());
            JobAdvertisement jobAdvertisement = modelMapper.map(jobAdvertisementDto, JobAdvertisement.class);
            jobAdvertisement.setCity(city);
            jobAdvertisement.setEmployer(employer);
            jobAdvertisement.setJobPosition(jobPosition);
            jobAdvertisement.setCreatedAt(LocalDateTime.now());
            //Tarihi otomatik ekletemedim buradan hallettim
            jobAdvertisementDao.save(jobAdvertisement);
            return new SuccessResult("İş ilanı eklendi");

            //bunun daha kolay yolu olmalı.
        }catch (Exception e){
            return new ErrorResult("Başarısız. Eksik veya hatalı bilgi girdiniz. "+e.getMessage());
        }

    }

    @Override
    public DataResult<List<JobAdvertisementDto>> findAllByEmployer_CompanyName(String companyName) {

        try {
            List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAllByEmployer_CompanyName(companyName);
            return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisements.stream()
                    .map(jobAdvertisement -> modelMapper.map(jobAdvertisement, JobAdvertisementDto.class))
                    .collect(Collectors.toList()), companyName + ": Adlı Şirketin İş ilanları");
        } catch (Exception e) {
            return new ErrorDataResult<List<JobAdvertisementDto>>("Başarısız. Error Message: "+ e.getMessage());
        }
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> findAllSortedByDate() {
        Sort sort = Sort.by(Sort.Direction.DESC,"createdAt");

        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAll(sort);

        return new SuccessDataResult<List<JobAdvertisementDto>>( jobAdvertisements.stream()
                .map(jobAdvertisement -> modelMapper.map(jobAdvertisement, JobAdvertisementDto.class))
                .collect(Collectors.toList()) );
    }

    @Override
    //Bunun daha iyi bir yolu var
    public DataResult<List<JobAdvertisementDto>> findAllByIsActiveTrue() {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAllByIsActiveTrue();

        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisements.stream()
        .map(jobAdvertisement -> modelMapper.map(jobAdvertisement, JobAdvertisementDto.class))
        .collect(Collectors.toList()));

    }

    public Result deleteById(int id){
        Optional<JobAdvertisement> jobAdvertisement = jobAdvertisementDao.findById(id);
        jobAdvertisement.orElseThrow().setIsActive(false);
        return new SuccessResult("İş ilanı kaldırıldı");
    }
}
