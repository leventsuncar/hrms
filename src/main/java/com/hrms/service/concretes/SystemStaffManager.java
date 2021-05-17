package com.hrms.service.concretes;

import com.hrms.dataAccess.abstracts.SystemStaffDao;
import com.hrms.dto.SystemStaffDto;
import com.hrms.entites.SystemStaff;
import com.hrms.entites.User;
import com.hrms.service.abstracts.SystemStaffService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SystemStaffManager implements SystemStaffService {

    private SystemStaffDao systemStaffDao;

    private ModelMapper modelMapper;

    public SystemStaffManager(SystemStaffDao systemStaffDao, ModelMapper modelMapper) {
        this.systemStaffDao = systemStaffDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public SystemStaff add(SystemStaffDto systemStaffDto, User user) {
        SystemStaff systemStaff = modelMapper.map(systemStaffDto, SystemStaff.class);
        systemStaff.setUserSystemStaff(user);
        return systemStaffDao.save(systemStaff);
    }

    @Override
    public List<SystemStaffDto> getAll() {
        List<SystemStaff> systemStaffList = systemStaffDao.findAll();
        return systemStaffList.stream().map(systemStaff -> modelMapper.map(systemStaff,
                SystemStaffDto.class)).collect(Collectors.toList());
    }
}
