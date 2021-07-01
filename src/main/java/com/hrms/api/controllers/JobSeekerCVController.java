package com.hrms.api.controllers;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dto.JobSeekerCVDto;
import com.hrms.entites.JobSeekerCV;
import com.hrms.service.abstracts.JobSeekerCVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/cv")
public class JobSeekerCVController {

    @Autowired
    JobSeekerCVService jobSeekerCVService;

    @GetMapping("/getall")
    public DataResult<List<JobSeekerCVDto>> getAll() {
        return jobSeekerCVService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobSeekerCVDto jobSeekerCVDto) {
        jobSeekerCVService.add(jobSeekerCVDto);
        return new SuccessResult("Başarılı");
    }
    @GetMapping("/cvdetail")
    public DataResult<JobSeekerCVDto> getById(@RequestParam int id){
       return jobSeekerCVService.getByJobSeeker(id);
    }


}
