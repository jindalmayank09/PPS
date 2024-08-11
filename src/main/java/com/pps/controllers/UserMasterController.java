package com.pps.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pps.model.Tutorial;
import com.pps.model.User;
import com.pps.service.CityService;
import com.pps.service.CountryService;
import com.pps.service.DBFileStorageService;
import com.pps.service.StateService;
import com.pps.service.UserCreationService;

@Controller
public class UserMasterController {

	
	@Autowired
	UserCreationService userCreationService;
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	StateService stateService;
	
	@Autowired
	CityService cityService;

	@Autowired
	DBFileStorageService dbFileStorageService;
	
	@RequestMapping(value = "/")
	public ModelAndView addNewUser() {
		ModelAndView model = new ModelAndView("createUser","user",new Tutorial());
		/*
		 * model.addObject("countries", countryService.getAllCountriesList());
		 * model.addObject("statesList", stateService.getAllStatesList());
		 * model.addObject("citiesList", cityService.getAllCitiesList());
		 */		
		return model;
	}
	
	

	@RequestMapping(value = "/saveNewUser", method = RequestMethod.POST)
	public ModelAndView saveNewUser(@ModelAttribute("tutorial") Tutorial tutorial) {
		tutorial = dbFileStorageService.storeTutorialData(tutorial);
		ModelAndView model = new ModelAndView("savedUserResponse","userObj",tutorial);
		model.addObject("responseMsg", tutorial.getId()>0?"Your Details has been saved Successfully!!!":"Error occured while saving your details!!!");
		return model;
	}
	
	@RequestMapping(value = "/addSubUsers", method = RequestMethod.POST)
	public ModelAndView addSubUsers(@RequestParam("userObj") String userObj ) {
		String userObject = userObj.split("&")[0];
		Integer userId = Integer.parseInt(userObject.split("_")[0]);
		String action = userObject.split("_")[1];
		User user = new User();
		user.setUserId(userId);
		user.setAction(action);
		user = userCreationService.createSubUserDtls(user);
		ModelAndView model = new ModelAndView("addedUserResponse","userObj",user);
		//model.addObject("responseMsg", !user.getIsUserExist()?"Your Details has been saved Successfully!!!<br>":user.getUserExistMsg());
		return model;
	}
	

}
