package com.lms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lmslogin")
public class LoginBeanEntity {
	//private instance variables
	private int serialNO;
	private String userName;
	private String password;
	private String role;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="serialNO")
	public int getSerialNO() {
		return serialNO;
	}
	public void setSerialNO(int serialNO) {
		this.serialNO = serialNO;
	}
	@Column(name="username")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="role")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
	
	