package com.hrms.api.controllers;

import com.hrms.core.utilities.apiPath.ApiPaths;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.dto.JobSeekerDto;
import com.hrms.service.abstracts.JobSeekerService;
import com.hrms.service.abstracts.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(ApiPaths.JobSeekersCtrl.CTRL)
@Api(value = ApiPaths.JobSeekersCtrl.CTRL)
public class JobSeekersController {

    JobSeekerService jobSeekerService;
    UserService userService;

    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService, UserService userService) {
        this.jobSeekerService = jobSeekerService;
        this.userService = userService;
    }

    @GetMapping("/getall")
    @ApiOperation(value = "Get All Job Seekers Operation", response = JobSeekerDto.class)
    public DataResult<List<JobSeekerDto>> getAll() {
        return jobSeekerService.getAll();
    }

    @PostMapping("/add")
    @ApiOperation(value = "Create Job Seeker Operation", response = JobSeekerDto.class)
    public Result add(@RequestBody JobSeekerDto jobSeekerDto) throws Exception {

        return jobSeekerService.add(jobSeekerDto);
    }
}
