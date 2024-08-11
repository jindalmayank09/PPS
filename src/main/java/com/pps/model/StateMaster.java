package com.pps.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pps_state_master")
public class StateMaster extends BaseEntity  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1264638877455167008L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="state_id")
	private Integer stateId;
	

	@Column(name="state_name")
	private String stateName;
	
	@Column(name="state_code")
	private String stateCode;
	
	@Column(name="country_id")
	private Integer countryId;



	public Integer getStateId() {
		return stateId;
	}


	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}


	public String getStateName() {
		return stateName;
	}


	public void setStateName(String stateName) {
		this.stateName = stateName;
	}


	public String getStateCode() {
		return stateCode;
	}


	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}


	public Integer getCountryId() {
		return countryId;
	}


	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}


	@Override
	public String toString() {
		return "StateMaster [stateId=" + stateId + ", stateName=" + stateName + ", stateCode=" + stateCode
				+ ", countryId=" + countryId + "]";
	}



}
