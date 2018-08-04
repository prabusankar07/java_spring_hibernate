package com.lms.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Primary;

@Entity
@Table(name="lmsextensionrequest")

public class LabExtensionRequestBeanEntity {
	//private instance variables
	private String bookingId;
	private String labId;
	private String labName;
	private String location;
	private String trainingName;
	private String loName;
	private String startDate;
	private String endDate;
	private String extensionDate;
	private String approval;
	
	@Id
	@Column(name="bookingid")
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getLabId() {
		return labId;
	}
	public void setLabId(String labId) {
		this.labId = labId;
	}
	@Column(name="labname")
	public String getLabName() {
		return labName;
	}
	public void setLabName(String labName) {
		this.labName = labName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public String getLoName() {
		return loName;
	}
	public void setLoName(String loName) {
		this.loName = loName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getExtensionDate() {
		return extensionDate;
	}
	public void setExtensionDate(String extensionDate) {
		this.extensionDate = extensionDate;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}

}
