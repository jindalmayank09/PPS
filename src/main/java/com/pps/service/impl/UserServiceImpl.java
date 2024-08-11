package com.pps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pps.dao.UserDao;
import com.pps.model.User;
import com.pps.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao employeeDao;

	@Override
	public void insertEmployee(User user) {
		employeeDao.insertEmployee(user);
	}

	@Override
	public void insertEmployees(List<User> users) {
		employeeDao.insertEmployees(users);
	}

	public List<User> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public void getEmployeeById(String empId) {
		User user = employeeDao.getEmployeeById(empId);
		System.out.println(user);
	}

}