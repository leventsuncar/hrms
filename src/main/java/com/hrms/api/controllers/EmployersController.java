package com.hrms.api.controllers;

import com.hrms.core.utilities.apiPath.ApiPaths;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.dto.EmployerDto;
import com.hrms.service.abstracts.EmployerService;
import com.hrms.service.abstracts.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.EmployersCtrl.CTRL)
@Api(value = ApiPaths.EmployersCtrl.CTRL)
public class EmployersController {

    EmployerService employerService;
    UserService userService;

    @Autowired
    public EmployersController(EmployerService employerService, UserService userService) {
        this.employerService = employerService;
        this.userService = userService;
    }

    @GetMapping("/getall")
    @ApiOperation(value = "Get All Employers Operation", response = EmployerDto.class)
    public DataResult<List<EmployerDto>> getAll() {

        return employerService.getAll();

    }

    @PostMapping("/add")
    @ApiOperation(value = "Create Employer Operation", response = EmployerDto.class)
    public Result add(@RequestBody EmployerDto employerDto) throws Exception {

        return employerService.add(employerDto);

    }


}
