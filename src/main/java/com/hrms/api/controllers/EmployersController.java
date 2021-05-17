package com.hrms.api.controllers;

import com.hrms.dto.EmployerDto;
import com.hrms.entites.Employer;
import com.hrms.entites.User;
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
    public List<EmployerDto> getAll() {

        return employerService.getAll();

    }

    @PostMapping("/add")
    public Employer add(@RequestBody EmployerDto employerDto) {
        User user = userService.addUserEmployer(employerDto);
        return employerService.add(employerDto, user);

    }


}
