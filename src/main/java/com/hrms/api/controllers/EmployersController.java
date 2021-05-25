package com.hrms.api.controllers;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.dto.EmployerDto;
import com.hrms.service.abstracts.EmployerService;
import com.hrms.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

    EmployerService employerService;
    UserService userService;

    @Autowired
    public EmployersController(EmployerService employerService, UserService userService) {
        this.employerService = employerService;
        this.userService = userService;
    }

    @GetMapping("/getall")
    public DataResult<List<EmployerDto>> getAll() {

        return employerService.getAll();

    }

    @PostMapping("/add")
    public Result add(@RequestBody EmployerDto employerDto) throws Exception {

        return employerService.add(employerDto);

    }


}
