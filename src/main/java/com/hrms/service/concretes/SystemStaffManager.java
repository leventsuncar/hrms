package com.hrms.service.concretes;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.SystemStaffDao;
import com.hrms.dto.SystemStaffDto;
import com.hrms.entites.SystemStaff;
import com.hrms.entites.User;
import com.hrms.service.abstracts.SystemStaffService;
import com.hrms.service.abstracts.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SystemStaffManager implements SystemStaffService {

    private SystemStaffDao systemStaffDao;

    private ModelMapper modelMapper;

    private UserService userService;

    public SystemStaffManager(SystemStaffDao systemStaffDao, UserService userService, ModelMapper modelMapper) {
        this.systemStaffDao = systemStaffDao;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    public Result add(SystemStaffDto systemStaffDto) {
        User user = userService.addUserSystemStaff(systemStaffDto);
        SystemStaff systemStaff = modelMapper.map(systemStaffDto, SystemStaff.class);
        systemStaff.setUserSystemStaff(user);
        systemStaffDao.save(systemStaff);
        return new SuccessResult("Sistem çalışanı eklendi");
    }

    @Override
    public DataResult<List<SystemStaffDto>> getAll() {
        List<SystemStaff> systemStaffList = systemStaffDao.findAll();
        return new SuccessDataResult<List<SystemStaffDto>>(systemStaffList.stream().map(systemStaff -> modelMapper.map(systemStaff,
                SystemStaffDto.class)).collect(Collectors.toList()));
    }
}
