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
import java.util.ArrayList;
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
        List<JobAdvertisementDto> jobAdvertisementDtoList = new ArrayList<>();
        for (JobAdvertisement jobAdvertisement : jobAdvertisementList) {
            JobAdvertisementDto jobAdvertisementDto = modelMapper.map(jobAdvertisement, JobAdvertisementDto.class);
            jobAdvertisementDto.setCityName(jobAdvertisement.getCity().getName());
            jobAdvertisementDto.setEmployerCompanyName(jobAdvertisement.getEmployer().getCompanyName());
            jobAdvertisementDto.setJobPositionName(jobAdvertisement.getJobPosition().getName());
            jobAdvertisementDto.setId(jobAdvertisement.getId());
            jobAdvertisementDtoList.add(jobAdvertisementDto);
        }


        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementDtoList);

    }

    @Override
    public Result add(JobAdvertisementDto jobAdvertisementDto) {
        try {
            Employer employer = employerDao.findByCompanyName(jobAdvertisementDto.getEmployerCompanyName());
            City city = cityDao.findByName(jobAdvertisementDto.getCityName());
            JobPosition jobPosition = jobPositionDao.findByName(jobAdvertisementDto.getJobPositionName());
            JobAdvertisement jobAdvertisement = modelMapper.map(jobAdvertisementDto, JobAdvertisement.class);
            if (cityDao.findByName(jobAdvertisementDto.getCityName()) == null) {
                City city1 = new City();
                city1.setName(jobAdvertisementDto.getCityName());
                cityDao.save(city1);
                jobAdvertisement.setCity(city1);
            } else {
                jobAdvertisement.setCity(city);
            }

            jobAdvertisement.setEmployer(employer);

            if (jobPositionDao.findByName(jobAdvertisementDto.getJobPositionName()) == null) {
                JobPosition jobPosition1 = new JobPosition();
                jobPosition1.setName(jobAdvertisementDto.getJobPositionName());
                jobPositionDao.save(jobPosition1);
                jobAdvertisement.setJobPosition(jobPosition1);
            } else {
                jobAdvertisement.setJobPosition(jobPosition);
            }

            jobAdvertisement.setCreatedAt(LocalDateTime.now());
            //Tarihi otomatik ekletemedim buradan hallettim
            jobAdvertisementDao.save(jobAdvertisement);
            return new SuccessResult("İş ilanı eklendi");

            //bunun daha kolay yolu olmalı.
        } catch (Exception e) {
            return new ErrorResult("Başarısız. Eksik veya hatalı bilgi girdiniz. " + e.getMessage());
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
            return new ErrorDataResult<List<JobAdvertisementDto>>("Başarısız. Error Message: " + e.getMessage());
        }
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> findAllSortedByDate() {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");

        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAll(sort);

        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisements.stream()
                .map(jobAdvertisement -> modelMapper.map(jobAdvertisement, JobAdvertisementDto.class))
                .collect(Collectors.toList()));
    }

    @Override
    //Bunun daha iyi bir yolu var
    public DataResult<List<JobAdvertisementDto>> findAllByIsActiveTrue() {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAllByIsActiveTrue();

        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisements.stream()
                .map(jobAdvertisement -> modelMapper.map(jobAdvertisement, JobAdvertisementDto.class))
                .collect(Collectors.toList()));

    }

    public Result deleteById(int id) {
        Optional<JobAdvertisement> jobAdvertisement = jobAdvertisementDao.findById(id);
        jobAdvertisement.orElseThrow().setIsActive(false);
        return new SuccessResult("İş ilanı kaldırıldı");
    }
    public DataResult<JobAdvertisementDto> getById(int id){
        JobAdvertisement jobAdvertisement = jobAdvertisementDao.getOne(id);
        JobAdvertisementDto jobAdvertisementDto = modelMapper.map(jobAdvertisement, JobAdvertisementDto.class);
        jobAdvertisementDto.setCityName(jobAdvertisement.getCity().getName());
        jobAdvertisementDto.setEmployerCompanyName(jobAdvertisement.getEmployer().getCompanyName());
        jobAdvertisementDto.setJobPositionName(jobAdvertisement.getJobPosition().getName());
        return new SuccessDataResult<JobAdvertisementDto>(jobAdvertisementDto, "Başarılı");
    }
    public DataResult<List<JobAdvertisementDto>> getAllByCity(String cityName){
        List<JobAdvertisement> jobAdvertisementList = jobAdvertisementDao.findAllByCity_Name(cityName);
        List<JobAdvertisementDto> jobAdvertisementDtoList = new ArrayList<>();
        for(JobAdvertisement jobAdvertisement : jobAdvertisementList){
            jobAdvertisementDtoList.add(mapAdvertisement(jobAdvertisement));
        }

        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementDtoList);
    }
    public JobAdvertisementDto mapAdvertisement(JobAdvertisement jobAdvertisement){
        JobAdvertisementDto jobAdvertisementDto = modelMapper.map(jobAdvertisement, JobAdvertisementDto.class);
        jobAdvertisementDto.setCityName(jobAdvertisement.getCity().getName());
        jobAdvertisementDto.setEmployerCompanyName(jobAdvertisement.getEmployer().getCompanyName());
        jobAdvertisementDto.setJobPositionName(jobAdvertisement.getJobPosition().getName());

        return jobAdvertisementDto;
    }
}
