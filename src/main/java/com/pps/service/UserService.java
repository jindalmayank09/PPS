package com.pps.service;

import java.util.List;

import com.pps.model.User;

public interface UserService {
	void insertEmployee(User emp);
	void insertEmployees(List<User> users);
	List<User> getAllEmployees();
	void getEmployeeById(String empid);
}