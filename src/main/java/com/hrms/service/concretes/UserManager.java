package com.hrms.service.concretes;

import com.hrms.dataAccess.abstracts.UserDao;
import com.hrms.dto.EmployerDto;
import com.hrms.dto.JobSeekerDto;
import com.hrms.dto.SystemStaffDto;
import com.hrms.dto.UserDto;
import com.hrms.entites.User;
import com.hrms.service.abstracts.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService {


    UserDao userDao;
    ModelMapper modelMapper;

    @Autowired
    public UserManager(UserDao userDao, ModelMapper modelMapper) {
        this.userDao = userDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> getAll() {
        List<User> userList = userDao.findAll();
        return userList.stream().map(login -> modelMapper.map(login, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public User addUserEmployer(EmployerDto employerDto) {
        User user = modelMapper.map(employerDto, User.class);
        user.setIsValid(false);
        //User tablosundaki isValid fieldını default olarak false geçiyorum.
        //Eğer kişi e posta doğrulamasını yaparsa true'ya çevireceğim
        return userDao.save(user);
    }

    public User addUserJobSeeker(JobSeekerDto jobSeekerDto) {
        User user = modelMapper.map(jobSeekerDto, User.class);
        user.setIsValid(false);
        return userDao.save(user);
    }

    @Override
    public User addUserSystemStaff(SystemStaffDto systemStaffDto) {
        User user = modelMapper.map(systemStaffDto, User.class);
        user.setIsValid(false);
        return userDao.save(user);
    }

}
