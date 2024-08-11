package com.pps.model;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name="user_master")
public class UserMaster  extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6324550998285107989L;
	
	public UserMaster() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="user_name")
	private String userName;
	

	@Column(name="user_contact")
	private String contactNo;

	@Column(name="user_email")
	private String email;

	@Transient
	private Boolean isUserExist;

	@Transient
	private String userExistMsg;
	@LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "userMaster", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<UserAddress> usersAddressList = new ArrayList<>();

    
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

	public List<UserAddress> getUsersAddressList() {
		return usersAddressList;
	}

	public void setUsersAddressList(List<UserAddress> usersAddressList) {
		this.usersAddressList = usersAddressList;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsUserExist() {
		return isUserExist;
	}

	public void setIsUserExist(Boolean isUserExist) {
		this.isUserExist = isUserExist;
	}

	public String getUserExistMsg() {
		return userExistMsg;
	}

	public void setUserExistMsg(String userExistMsg) {
		this.userExistMsg = userExistMsg;
	}




}