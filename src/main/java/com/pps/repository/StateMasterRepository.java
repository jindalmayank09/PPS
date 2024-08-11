package com.pps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pps.model.StateMaster;

public interface StateMasterRepository extends JpaRepository<StateMaster, Integer>{

	List<StateMaster> findByCountryId(Integer countryId);

}
