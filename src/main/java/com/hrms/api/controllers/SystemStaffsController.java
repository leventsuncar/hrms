package com.hrms.api.controllers;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.dto.SystemStaffDto;
import com.hrms.service.abstracts.SystemStaffService;
import com.hrms.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/systemstaff")
public class SystemStaffsController {
    SystemStaffService systemStaffService;
    UserService userService;

    @Autowired
    public SystemStaffsController(SystemStaffService systemStaffService, UserService userService) {
        this.systemStaffService = systemStaffService;
        this.userService = userService;
    }

    @GetMapping("/getall")
    public DataResult<List<SystemStaffDto>> getAll() {
        return systemStaffService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody SystemStaffDto systemStaffDto) {

        return systemStaffService.add(systemStaffDto);
    }
}
