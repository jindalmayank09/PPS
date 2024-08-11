package com.pps.model;

import java.io.Serializable;
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
@Table(name="pps_sub_user_master")
public class SubUser  extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6324550998285107989L;
	
	public SubUser() {
		super();
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sequence_id")
	private Integer seq;
	

	@Column(name="name")
	private String userName;
	
	@Column(name="gender")
	private String gender;

	
	@Column(name="address")
	private String userAddress;
	
	
	@Column(name="aadhar_no")
	private String aadharNo;

	@Column(name="contact_no")
	private String contactNo;

	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="age")
	private Integer age;

	@Column(name="reg_no")
	private String regNo;

	@Transient
	private String stayPeriod;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SubUser [user=" + user + ", seq=" + seq + ", userName=" + userName + ", gender=" + gender
				+ ", userAddress=" + userAddress + ", aadharNo=" + aadharNo + ", contactNo=" + contactNo
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", age=" + getAge() + ", regNo=" + regNo + "]";
	}

	public String getStayPeriod() {
		return stayPeriod;
	}

	public void setStayPeriod(String stayPeriod) {
		this.stayPeriod = stayPeriod;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}