package com.hrms.adapter.mernisAdapter.concretes;

import com.hrms.adapter.mernisAdapter.abstracts.MernisAdapterService;
import com.hrms.dto.JobSeekerDto;
import com.hrms.mernis.CJEKPSPublicSoap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MernisManagerAdapter implements MernisAdapterService {

    CJEKPSPublicSoap cjekpsPublicSoap;

    @Autowired
    public MernisManagerAdapter(CJEKPSPublicSoap cjekpsPublicSoap) {
        this.cjekpsPublicSoap = cjekpsPublicSoap;
    }

    @Override
    public Boolean verifyNationalId(JobSeekerDto jobSeekerDto) throws Exception {
        return cjekpsPublicSoap.TCKimlikNoDogrula(jobSeekerDto.getNationalId(), jobSeekerDto.getFirstName(), jobSeekerDto.getLastName(), jobSeekerDto.getBirthYear());

    }
}
