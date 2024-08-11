package com.pps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pps.model.CountryMaster;
import com.pps.repository.CountryMasterRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryMasterRepository countryMasterRepository;
	
	public List<CountryMaster> getAllCountriesList(){
		
		return countryMasterRepository.findAll();
	}
}