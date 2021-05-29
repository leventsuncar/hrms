package com.hrms.service.abstracts;


import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.dto.JobAdvertisementDto;

import java.util.List;

public interface JobAdversitementService {

    DataResult<List<JobAdvertisementDto>> getAll();
    Result add(JobAdvertisementDto jobAdvertisementDto);
    DataResult<List<JobAdvertisementDto>> findAllByEmployer_CompanyName(String companyName);
    DataResult<List<JobAdvertisementDto>> findAllSortedByDate();
}
