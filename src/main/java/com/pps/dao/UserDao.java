package com.pps.dao;

import java.util.List;

import com.pps.model.User;

public interface UserDao {
	void insertEmployee(User cus);
	void insertEmployees(List<User> users);
	List<User> getAllEmployees();
	User getEmployeeById(String empId);
	Integer getNextUserId(String seqName)throws Exception;
	List<User> getAllUsersSelectedColums(User user);
}