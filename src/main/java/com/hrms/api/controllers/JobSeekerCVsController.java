package com.hrms.api.controllers;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.dto.JobSeekerCVDto;
import com.hrms.service.abstracts.JobSeekerCVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cv")
public class JobSeekerCVsController {

    @Autowired
    JobSeekerCVService jobSeekerCVService;

    @GetMapping("/getall")
    DataResult<List<JobSeekerCVDto>> getAll(){
        return jobSeekerCVService.getAll();
    }


}
