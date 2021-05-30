package com.hrms.api.controllers;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.dto.JobAdvertisementDto;
import com.hrms.service.abstracts.JobAdversitementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementsController {

    @Autowired
    private JobAdversitementService jobAdversitementService;


    @GetMapping("/getall")
    public DataResult<List<JobAdvertisementDto>> getAll() {
        return jobAdversitementService.getAll();
    }

    @PostMapping("/add")
    public Result add(JobAdvertisementDto jobAdvertisementDto) {
        return jobAdversitementService.add(jobAdvertisementDto);
    }

    @GetMapping("/findbycompanyname")
    public DataResult<List<JobAdvertisementDto>> findAllByEmployer_CompanyName(@RequestParam String companyName) {
        return jobAdversitementService.findAllByEmployer_CompanyName(companyName);
    }

    @GetMapping("/sortbycreatedat")
    public DataResult<List<JobAdvertisementDto>> findAllSortedByDate() {
        return jobAdversitementService.findAllSortedByDate();
    }

    @GetMapping("/findactive")
    public DataResult<List<JobAdvertisementDto>> findAllByIsActiveTrue() {
        return jobAdversitementService.findAllByIsActiveTrue();
    }
    @PutMapping
    public Result deleteById(@RequestParam int id){
       return jobAdversitementService.deleteById(id);

    }
}
