package com.pps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pps.model.CityMaster;

public interface CityMasterRepository extends JpaRepository<CityMaster, Integer>{

	List<CityMaster> findByStateId(Integer stateId);

	List<CityMaster> findByStateIdAndCountryId(Integer stateId, Integer countryId);

}
