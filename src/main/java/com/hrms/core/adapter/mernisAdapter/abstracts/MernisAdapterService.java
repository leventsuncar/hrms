package com.hrms.core.adapter.mernisAdapter.abstracts;

import com.hrms.dto.JobSeekerDto;

public interface MernisAdapterService {
    Boolean verifyNationalId(JobSeekerDto jobSeekerDto) throws Exception;
}
