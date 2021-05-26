package com.hrms.api.controllers;

import com.hrms.core.utilities.apiPath.ApiPaths;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.dto.SystemStaffDto;
import com.hrms.service.abstracts.SystemStaffService;
import com.hrms.service.abstracts.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/systemstaff")
@Api(value = ApiPaths.SystemStaffsCtrl.CTRL)
public class SystemStaffsController {
    SystemStaffService systemStaffService;
    UserService userService;

    @Autowired
    public SystemStaffsController(SystemStaffService systemStaffService, UserService userService) {
        this.systemStaffService = systemStaffService;
        this.userService = userService;
    }

    @GetMapping("/getall")
    @ApiOperation(value = "Get All System Staffs Operation", response = SystemStaffDto.class)
    public DataResult<List<SystemStaffDto>> getAll() {
        return systemStaffService.getAll();
    }

    @PostMapping("/add")
    @ApiOperation(value = "Create System Staff Operation", response = SystemStaffDto.class)
    public Result add(@RequestBody SystemStaffDto systemStaffDto) {

        return systemStaffService.add(systemStaffDto);
    }
}
