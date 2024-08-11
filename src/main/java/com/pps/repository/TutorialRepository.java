package com.pps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pps.model.Tutorial;


public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
	public List<Tutorial> findAll();

	@Query("from Tutorial t where t.name like %?1% or t.phoneNo like %?1%")
	public List<Tutorial> searchByUserInput(String searchVal);
	
	
	public long count();
}
