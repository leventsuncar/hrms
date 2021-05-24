package com.hrms.core.adapter.mernisAdapter.concretes;

import com.hrms.core.adapter.mernisAdapter.abstracts.MernisAdapterService;
import com.hrms.dto.JobSeekerDto;
import com.hrms.mernis.DAVKPSPublicSoap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MernisManagerAdapter implements MernisAdapterService {

    @Autowired
    DAVKPSPublicSoap davkpsPublicSoap;

    //Mernis servisi bize boolean dönüyor.
    @Override
    public Boolean verifyNationalId(JobSeekerDto jobSeekerDto) throws Exception {
        return davkpsPublicSoap.TCKimlikNoDogrula(jobSeekerDto.getNationalId(),
                jobSeekerDto.getFirstName(), jobSeekerDto.getLastName(), jobSeekerDto.getBirthYear());

    }
}
