package com.hrms.api.controllers;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.dto.JobSeekerDto;
import com.hrms.service.abstracts.JobSeekerService;
import com.hrms.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {

    JobSeekerService jobSeekerService;
    UserService userService;

    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService, UserService userService) {
        this.jobSeekerService = jobSeekerService;
        this.userService = userService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobSeekerDto>> getAll() {
        return jobSeekerService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobSeekerDto jobSeekerDto) throws Exception {

        return jobSeekerService.add(jobSeekerDto);
    }
}
