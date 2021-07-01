package com.hrms.service.concretes;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.*;
import com.hrms.dto.*;
import com.hrms.entites.*;
import com.hrms.service.abstracts.JobSeekerCVService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobSeekerCVManager implements JobSeekerCVService {

    @Autowired
    JobSeekerCVDao jobSeekerCVDao;
    @Autowired
    CVEducationDao cvEducationDao;
    @Autowired
    CVExperienceDao cvExperienceDao;
    @Autowired
    CVCompetenciesDao cvCompetenciesDao;
    @Autowired
    CVLanguageDao cvLanguageDao;
    @Autowired
    CVSocialLinkDao cvSocialLinkDao;
    @Autowired
    JobSeekerDao jobSeekerDao;
    @Autowired
    ModelMapper modelMapper;


    @Override
    public DataResult<List<JobSeekerCVDto>> getAll() {
        List<JobSeekerCVDto> jobSeekerCVDtoList = new ArrayList<>();
        List<JobSeekerCV> jobSeekerCVList = jobSeekerCVDao.findAll();


        for (JobSeekerCV jobSeekerCV : jobSeekerCVList) {
            //Buralar biraz karışık.

            jobSeekerCVDtoList.add(mapCV(jobSeekerCV));
        }


        return new SuccessDataResult<List<JobSeekerCVDto>>(jobSeekerCVDtoList);
        //gerekli dto listemiz hazır.
    }

    @Override
    @Transactional
    public Result add(JobSeekerCVDto jobSeekerCVDto) {

        JobSeekerCV jobSeekerCV = modelMapper.map(jobSeekerCVDto, JobSeekerCV.class);

        CVEducation cvEducation = modelMapper.map(jobSeekerCVDto.getCvEducationDto(), CVEducation.class);
        cvEducation.setJobSeekerCV(jobSeekerCV);
        cvEducationDao.save(cvEducation);
        jobSeekerCV.setCvEducation(cvEducation);

        CVSocialLinks cvSocialLinks = modelMapper.map(jobSeekerCVDto.getCvSocialLinkDto(), CVSocialLinks.class);
        cvSocialLinks.setJobSeekerCV(jobSeekerCV);
        cvSocialLinkDao.save(cvSocialLinks);
        jobSeekerCV.setCvSocialLinks(cvSocialLinks);

        List<CVLanguageDto> cvLanguageDtoList = jobSeekerCVDto.getCvLanguageDtoList();
        List<CVLanguages> cvLanguagesList = (cvLanguageDtoList.stream()
                .map(cvLanguages -> modelMapper.map(cvLanguages, CVLanguages.class))
                .collect(Collectors.toList()));
        for (CVLanguages cvLanguages : cvLanguagesList) {
            cvLanguages.setJobSeekerCV(jobSeekerCV);
            cvLanguageDao.save(cvLanguages);
        }
        jobSeekerCV.setCvLanguages(cvLanguagesList);


        List<CVExperienceDto> cvExperienceDtoList = jobSeekerCVDto.getCvExperienceDtoList();
        List<CVExperience> cvExperienceList = (cvExperienceDtoList.stream()
                .map(cvExperience -> modelMapper.map(cvExperience, CVExperience.class))
                .collect(Collectors.toList()));
        for (CVExperience cvExperience : cvExperienceList) {
            cvExperience.setJobSeekerCV(jobSeekerCV);
            cvExperienceDao.save(cvExperience);
        }
        jobSeekerCV.setCvExperiences(cvExperienceList);


        List<CVCompentenciesDto> cvCompentenciesDtoList = jobSeekerCVDto.getCvCompentenciesDtoList();
        List<CVCompetencies> cvCompentenciesList = (cvCompentenciesDtoList.stream()
                .map(cvCompentencies -> modelMapper.map(cvCompentencies, CVCompetencies.class))
                .collect(Collectors.toList()));
        for (CVCompetencies cvCompentencies : cvCompentenciesList) {
            cvCompentencies.setJobSeekerCV(jobSeekerCV);
            cvCompetenciesDao.save(cvCompentencies);
        }
        jobSeekerCV.setCvCompetencies(cvCompentenciesList);


        jobSeekerCV.setJobSeeker(jobSeekerDao.findByUserJobSeeker_Email(jobSeekerCVDto.getEmail()));

        jobSeekerCVDao.save(jobSeekerCV);
        return new SuccessResult("Başarılı");
    }

    @Override
    public DataResult<JobSeekerCVDto> getByJobSeeker(int id) {
        JobSeeker jobSeeker = jobSeekerDao.getOne(id);
        JobSeekerCV jobSeekerCV = jobSeekerCVDao.findByJobSeeker(jobSeeker);


        return new SuccessDataResult<JobSeekerCVDto>(mapCV(jobSeekerCV),"Başarılı inş");
    }

    @Override
    public DataResult<List<JobSeekerCVDto>> sortedByExperienceYearAndEducationEndYear() {
        return null;
    }
    public JobSeekerCVDto mapCV(JobSeekerCV jobSeekerCV){
        JobSeekerCVDto jobSeekerCVDto = modelMapper.map(jobSeekerCV, JobSeekerCVDto.class);
        //Elimizdeli entityleri dto ya dönüştürüyoruz.
        List<CVCompetencies> cvCompetencies = jobSeekerCV.getCvCompetencies();
        List<CVCompentenciesDto> cvCompentenciesDtoList = (cvCompetencies.stream()
                .map(cvCompetencies1 -> modelMapper.map(cvCompetencies1, CVCompentenciesDto.class))
                .collect(Collectors.toList()));
        jobSeekerCVDto.setCvCompentenciesDtoList(cvCompentenciesDtoList);
        //Dtodaki fieldları doldurmak için bir takım dönüştürmeler yapıyoruz
        //ve bunları dtomuzun içine set ediyoruz

        List<CVExperience> cvExperienceList = jobSeekerCV.getCvExperiences();
        List<CVExperienceDto> experienceDtoList = (cvExperienceList.stream()
                .map(cvExperience -> modelMapper.map(cvExperience, CVExperienceDto.class))
                .collect(Collectors.toList()));

        jobSeekerCVDto.setCvExperienceDtoList(experienceDtoList);

        List<CVLanguages> cvLanguagesList = jobSeekerCV.getCvLanguages();
        List<CVLanguageDto> cvLanguageDtoList = (cvLanguagesList.stream()
                .map(cvLanguages -> modelMapper.map(cvLanguages, CVLanguageDto.class))
                .collect(Collectors.toList()));
        jobSeekerCVDto.setCvLanguageDtoList(cvLanguageDtoList);

        CVEducation cvEducation = jobSeekerCV.getCvEducation();
        jobSeekerCVDto.setCvEducationDto(modelMapper.map(cvEducation, CVEducationDto.class));

        CVSocialLinks socialLinks = jobSeekerCV.getCvSocialLinks();
        jobSeekerCVDto.setCvSocialLinkDto(modelMapper.map(socialLinks, CVSocialLinkDto.class));
        //bunu gerektiği kadar tekrarladıktan sonra yukarıda tanımladığımız dto listesine ekliyoruz.
        jobSeekerCVDto.setJobSeekerFirstName(jobSeekerCV.getJobSeeker().getFirstName());
        jobSeekerCVDto.setJobSeekerLastName(jobSeekerCV.getJobSeeker().getLastName());
        jobSeekerCVDto.setEmail(jobSeekerCV.getJobSeeker().getUserJobSeeker().getEmail());
        jobSeekerCVDto.setJobSeekerBirthYear(jobSeekerCV.getJobSeeker().getBirthYear());


        return jobSeekerCVDto;
    }
}

