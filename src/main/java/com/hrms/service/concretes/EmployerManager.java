package com.hrms.service.concretes;

import com.hrms.core.utilities.results.*;
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
    public Result add(EmployerDto employerDto) throws Exception {

        //eğer girilen 2 şifre doğruysa
        if (employerDto.getPassword().equals(employerDto.getConfirmPassword())) {
            User user = userService.addUserEmployer(employerDto);
            //user serviceden gelen metodla user ekle bilgileri employer dto dan al
            Employer employer = modelMapper.map(employerDto, Employer.class);
            //employer dto yu bir employer nesnesine dönüştür
            employer.setUserEmployer(user);
            //emplyoyer nesnesindeki user alanına yukarıda eklediğim user ı ekle
            employerDao.save(employer);
            //employerı kaydet
            return new SuccessResult("İş veren eklendi");
        } else {
            //şifre
            return new ErrorResult("Şifreler uyuşmuyor");
        }
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
