package com.hrms.api.controllers;

import com.hrms.core.utilities.apiPath.ApiPaths;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.dto.JobPositionDto;
import com.hrms.service.abstracts.JobPositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.JobPositionsCtrl.CTRL)
@Api(value = ApiPaths.JobPositionsCtrl.CTRL)
public class JobPositionsController {

    JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    @ApiOperation(value = "Get All Job Positions Operation", response = JobPositionDto.class)
    public DataResult<List<JobPositionDto>> getAll() {
        return jobPositionService.getAll();
    }

    @PostMapping("/add")
    @ApiOperation(value = "Create Job Position Operation", response = JobPositionDto.class)
    public Result add(@RequestBody JobPositionDto jobPosition) {
        return jobPositionService.add(jobPosition);
    }


}
