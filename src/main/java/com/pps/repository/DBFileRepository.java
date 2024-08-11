package com.pps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pps.model.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

}
