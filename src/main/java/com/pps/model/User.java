package com.pps.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="pps_user_master")
public class User  extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6324550998285107989L;
	
	public User() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="name")
	private String userName;
	
	@Column(name="gender")
	private String gender;

	
	@Column(name="address")
	private String userAddress;
	
	@Column(name="city_id")
	private Integer cityId;
	
	@Column(name="state_id")
	private Integer stateId;
	
	@Column(name="country_id")
	private Integer countryId;
	
	@Column(name="pincode")
	private String userPinCode;
	
	@Column(name="accomodation")
	private String accomodation;
	
	@Column(name="aadhar_no")
	private String aadharNo;

	@Column(name="contact_no")
	private String contactNo;

	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	
	@Column(name="total_fare")
	private Double totalFare;

	@Column(name="registaration_no")
	private String regNo;

	@Column(name="is_dixit")
	private String isDixit;

	@Column(name="age")
	private Integer age;

	@Column(name="referred_by")
	private String referredBy;

	@Column(name="referred_by_contact_no")
	private String referredByCnctNo;

	@Column(name="no_of_m_persons")
	private Integer noOfMPrsns;
	
	@Column(name="no_of_f_persons")
	private Integer noOfFPrsns;

	@Column(name="is_mbr_of_pps")
	private String isMbrOfPps;

	@Column(name="country")
	private String country;

	@Column(name="state")
	private String state;

	@Column(name="city")
	private String city;

	@Column(name="remarks")
	private String remarks;
	
	@Column(name="arr_time")
	private String arrTime;
	
	@Column(name="dept_time")
	private String deptTime;

	@Column(name="enrollment_no")
	private String enrollNo;

	@LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<SubUser> subUsersList = new ArrayList<>();

	@Transient
	private String action;
	
	@Transient
    private Integer pageNumber=1;
   
    @Transient
    private Integer maxRecordPerPage=0; 
    
    @Transient
    private List<String> userSelectedFields = new ArrayList<>();
    
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getUserPinCode() {
		return userPinCode;
	}

	public void setUserPinCode(String userPinCode) {
		this.userPinCode = userPinCode;
	}

	public String getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(String accomodation) {
		this.accomodation = accomodation;
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


	public Double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	

	public String getIsDixit() {
		return isDixit;
	}

	public void setIsDixit(String isDixit) {
		this.isDixit = isDixit;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	public String getReferredByCnctNo() {
		return referredByCnctNo;
	}

	public void setReferredByCnctNo(String referredByCnctNo) {
		this.referredByCnctNo = referredByCnctNo;
	}

	public Integer getNoOfMPrsns() {
		return noOfMPrsns;
	}

	public void setNoOfMPrsns(Integer noOfMPrsns) {
		this.noOfMPrsns = noOfMPrsns;
	}

	public Integer getNoOfFPrsns() {
		return noOfFPrsns;
	}

	public void setNoOfFPrsns(Integer noOfFPrsns) {
		this.noOfFPrsns = noOfFPrsns;
	}

	public String getIsMbrOfPps() {
		return isMbrOfPps;
	}

	public void setIsMbrOfPps(String isMbrOfPps) {
		this.isMbrOfPps = isMbrOfPps;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<SubUser> getSubUsersList() {
		return subUsersList;
	}

	public void setSubUsersList(List<SubUser> subUsersList) {
		this.subUsersList = subUsersList;
	}

    public Integer getPageNumber() {
        return pageNumber;
     }

     public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
     }

     public Integer getMaxRecordPerPage() {
        return maxRecordPerPage;
     }

     public void setMaxRecordPerPage(Integer maxRecordPerPage) {
        this.maxRecordPerPage = maxRecordPerPage;
     }

	public String getArrTime() {
		return arrTime;
	}

	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}

	public String getDeptTime() {
		return deptTime;
	}

	public void setDeptTime(String deptTime) {
		this.deptTime = deptTime;
	}

	

	public List<String> getUserSelectedFields() {
		return userSelectedFields;
	}

	public void setUserSelectedFields(List<String> userSelectedFields) {
		this.userSelectedFields = userSelectedFields;
	}

	public String getEnrollNo() {
		return enrollNo;
	}

	public void setEnrollNo(String enrollNo) {
		this.enrollNo = enrollNo;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", gender=" + gender + ", userAddress="
				+ userAddress + ", cityId=" + cityId + ", stateId=" + stateId + ", countryId=" + countryId
				+ ", userPinCode=" + userPinCode + ", accomodation=" + accomodation + ", aadharNo=" + aadharNo
				+ ", contactNo=" + contactNo + ", startDate=" + startDate + ", endDate=" + endDate + ", totalFare="
				+ totalFare + ", regNo=" + regNo + ", isDixit=" + isDixit + ", age=" + age + ", referredBy="
				+ referredBy + ", referredByCnctNo=" + referredByCnctNo + ", noOfMPrsns=" + noOfMPrsns + ", noOfFPrsns="
				+ noOfFPrsns + ", isMbrOfPps=" + isMbrOfPps + ", country=" + country + ", state=" + state + ", city="
				+ city + ", remarks=" + remarks + ", arrTime=" + arrTime + ", deptTime=" + deptTime + ", enrollNo="
				+ enrollNo + ", subUsersList=" + subUsersList + ", action=" + action + ", pageNumber=" + pageNumber
				+ ", maxRecordPerPage=" + maxRecordPerPage + ", userSelectedFields=" + userSelectedFields + "]";
	}



}