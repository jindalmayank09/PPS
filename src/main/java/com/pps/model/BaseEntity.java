package com.pps.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@javax.persistence.MappedSuperclass
public abstract class BaseEntity {

	@Column(name="status")
	private Boolean status;
	
	@Column(name="created_by", updatable = false)
	private String createdBy;
	
	@Column(name="creation_time", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date creationTime;
	
	@Column(name="last_updated_time")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date lastUpdatedTime;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	@Override
	public String toString() {
		return "BaseEntity [status=" + status + ", createdBy=" + createdBy + ", creationTime=" + creationTime
				+ ", lastUpdatedTime=" + lastUpdatedTime + "]";
	}

}
