package com.hrms.api.controllers;

import com.hrms.entites.concretes.JobPosition;
import com.hrms.service.abstracts.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobposition")
public class JobPositionsController {

    JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public List<JobPosition> getAll(){
        return jobPositionService.getAll();
    }

    @PostMapping("/add")
    public JobPosition add(@RequestBody JobPosition jobPosition){
        return jobPositionService.add(jobPosition);
    }


}
