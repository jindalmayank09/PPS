package com.pps.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "excel_child")
public class Tutorial {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "master_id")
	private DBFile excelMaster;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "child_id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "place")
	private String place;

	@Column(name = "dob")
	private String dob;
	
	@Column(name = "phone_no")
	private String phoneNo;

	@Column(name = "from_date")
	private String fromDate;
	
	@Column(name = "to_date")
	private String toDate;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="gender")
	private String gender;
	
	@Transient
	private String searchParam;

	public Tutorial() {

	}







	public Tutorial(long id, String name, String place, String dob, String phoneNo, String fromDate, String toDate,
			Date creationDate, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
		this.dob = dob;
		this.phoneNo = phoneNo;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.creationDate = creationDate;
		this.gender = gender;
	}







	public Tutorial(String name, String place, String dob,String phoneNo) {
		this.name = name;
		this.place = place;
		this.dob = dob;
		this.phoneNo = phoneNo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", name=" + name + ", place=" + place + ", dob=" + dob + ", phoneNo=" + phoneNo
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", creationDate=" + creationDate + ", gender="
				+ gender + "]";
	}







	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public DBFile getExcelMaster() {
		return excelMaster;
	}

	public void setExcelMaster(DBFile excelMaster) {
		this.excelMaster = excelMaster;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getSearchParam() {
		return searchParam;
	}

	public void setSearchParam(String searchParam) {
		this.searchParam = searchParam;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}

}
