package com.hrms.service.concretes;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.dataAccess.abstracts.*;
import com.hrms.dto.*;
import com.hrms.entites.*;
import com.hrms.service.abstracts.JobSeekerCVService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    ModelMapper modelMapper;


    @Override
    public DataResult<List<JobSeekerCVDto>> getAll() {
        List<JobSeekerCVDto> jobSeekerCVDtoList = new ArrayList<>();
        List<JobSeekerCV> jobSeekerCVList = jobSeekerCVDao.findAll();



        for (JobSeekerCV jobSeekerCV : jobSeekerCVList) {
            //Buralar biraz karışık.
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
            jobSeekerCVDtoList.add(jobSeekerCVDto);
        }


        return new SuccessDataResult<List<JobSeekerCVDto>>(jobSeekerCVDtoList);
        //gerekli dto listemiz hazır.
    }

    @Override
    public Result add(JobSeekerCVDto jobSeekerCVDto) {
        return null;
    }

    @Override
    public DataResult<List<JobSeekerCVDto>> sortedByExperienceYearAndEducationEndYear() {
        return null;
    }
}
