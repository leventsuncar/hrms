package com.hrms.dataAccess.abstracts;

import com.hrms.entites.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> findAllByEmployer_CompanyName(String companyName);
}
