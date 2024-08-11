package com.pps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pps.model.StateMaster;
import com.pps.repository.StateMasterRepository;

@Service
public class StateService {
	
	@Autowired
	private StateMasterRepository stateMasterRepository;
	
	public List<StateMaster> getAllStatesList(){
		return stateMasterRepository.findAll();
	}
	public Object getAllStatesListByCountryId(Integer countryId){
		String statesJson = "";
		try {
			statesJson  =  new ObjectMapper().writeValueAsString(stateMasterRepository.findByCountryId(countryId));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statesJson;
	}

}