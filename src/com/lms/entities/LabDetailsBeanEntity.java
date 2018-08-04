package com.lms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lmsdetails")
public class LabDetailsBeanEntity {
	private String labId;
	private String labName;
	private String type;
	private String country;
	private String city;
	private String capacity;
	private String status;
	private String projector;
	private String phone;
	private String mike;
	private String soundSystem;
	private String videoConference;
	private String airConditioner;
	private String whiteBoard;
	private String systemsAvailable;
	
	@Id
	public String getLabId() {
		return labId;
	}
	public void setLabId(String labId) {
		this.labId = labId;
	}
		public String getLabName() {
		return labName;
	}
	public void setLabName(String labName) {
		this.labName = labName;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProjector() {
		return projector;
	}
	public void setProjector(String projector) {
		this.projector = projector;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMike() {
		return mike;
	}
	public void setMike(String mike) {
		this.mike = mike;
	}
	public String getSoundSystem() {
		return soundSystem;
	}
	public void setSoundSystem(String soundSystem) {
		this.soundSystem = soundSystem;
	}
	public String getVideoConference() {
		return videoConference;
	}
	public void setVideoConference(String videoConference) {
		this.videoConference = videoConference;
	}
	public String getAirConditioner() {
		return airConditioner;
	}
	public void setAirConditioner(String airConditioner) {
		this.airConditioner = airConditioner;
	}
	public String getWhiteBoard() {
		return whiteBoard;
	}
	public void setWhiteBoard(String whiteBoard) {
		this.whiteBoard = whiteBoard;
	}
	@Column(name="systemavailable")
	public String getSystemsAvailable() {
		return systemsAvailable;
	}
	public void setSystemsAvailable(String systemsAvailable) {
		this.systemsAvailable = systemsAvailable;
	}
	
	
	
	


}
