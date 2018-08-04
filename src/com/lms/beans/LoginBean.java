package com.lms.beans;

import org.springframework.stereotype.Component;

public class LoginBean {
	//private instance variables
	private int serialNO;
	private String userName;
	private String password;
	private String role;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getSerialNO() {
		return serialNO;
	}
	public void setSerialNO(int serialNO) {
		this.serialNO = serialNO;
	}
	
}
	
	