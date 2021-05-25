package com.hrms.service.concretes;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.dto.EmployerDto;
import com.hrms.entites.Employer;
import com.hrms.entites.User;
import com.hrms.service.abstracts.EmployerService;
import com.hrms.service.abstracts.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployerManager implements EmployerService {

    @Autowired
    private EmployerDao employerDao;        //Field injection is no recommended

    @Autowired
    private ModelMapper modelMapper;        //Field injection önerilmez constructorla yapılacak

    @Autowired
    private UserService userService;        //Böyle de kullanılabilir Engin Hoca bunu önermiyor

    @Override
    public Result add(EmployerDto employerDto) {

        User user = userService.addUserEmployer(employerDto);
        //employer dto dan gelen user verileriyle yeni user ekliyorum.
        Employer employer = modelMapper.map(employerDto, Employer.class);
        //employerDto yu employer' çeviriyorum
        employer.setUserEmployer(user);
        //employer daki user fieldına yukarıda oluşturduğum user'ı ekliyorum.
        employerDao.save(employer);
        return new SuccessResult("İş veren eklendi");

    }

    @Override
    public DataResult<List<EmployerDto>> getAll() {
        List<Employer> employerList = employerDao.findAll();

        return new SuccessDataResult<List<EmployerDto>>(employerList.stream().map
                (employer -> modelMapper.map(employer, EmployerDto.class))
                .collect(Collectors.toList()), "İş veren listesi");

    }

    @Override
    public Result delete(Employer employer) {
        //Zamanla eklenecek
        return null;
    }

    @Override
    public Result update(Employer employer) {
        //Zamanla eklenecek
        return null;
    }
}
