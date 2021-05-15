package com.hrms.service.concretes;

import com.hrms.dataAccess.abstracts.UserDao;
import com.hrms.dto.EmployerDto;
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
    public User add(EmployerDto employerDto) {
        User user = modelMapper.map(employerDto, User.class);
        user.setIsValid(false);

        return userDao.save(user);
    }
}
