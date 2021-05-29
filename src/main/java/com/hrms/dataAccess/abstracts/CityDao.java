package com.hrms.dataAccess.abstracts;

import com.hrms.entites.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Integer> {

    City findByName(String cityName);

}
