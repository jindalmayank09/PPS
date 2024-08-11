package com.pps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pps.model.User;

public interface UserCreationRepository extends JpaRepository<User, Integer>{

	
	  List<User> findAllByOrderByLastUpdatedTimeDesc();
	  
	  List<User> findByRegNo(String regNo);
	  
	  List<User> findByUserName(String userName);
	  
	  @Query("from User") List<User> getAllUsers();
	 
	  User getOne(Integer userId);
	
		/* UserMaster findByContactNo(String contactNo); */
}
