package com.hrms.api.controllers;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.dto.JobPositionDto;
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
    public DataResult<List<JobPositionDto>> getAll() {
        return jobPositionService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPositionDto jobPosition) {
        return jobPositionService.add(jobPosition);
    }


}
