package com.pps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pps.model.CityMaster;
import com.pps.repository.CityMasterRepository;

@Service
public class CityService {
	
	@Autowired
	private CityMasterRepository cityMasterRepository;
	
	public List<CityMaster> getAllCitiesList(){
		
		return cityMasterRepository.findAll();
	}
	
	public List<CityMaster> getAllCitiesByStateId(Integer stateId){
		
		return cityMasterRepository.findByStateId(stateId);
	}

	public Object getAllCitiesByStateIdAndCountryId(Integer stateId,Integer countryId){
		String citiesJson = "";
		try {
			citiesJson  =  new ObjectMapper().writeValueAsString(cityMasterRepository.findByStateIdAndCountryId(stateId,countryId));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return citiesJson;
	}


}