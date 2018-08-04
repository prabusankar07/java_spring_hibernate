package com.lms.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lms.beans.LoginBean;
import com.lms.dao.LoginDAO;
@Component
public class LoginModelImpl implements LoginModel {
	@Autowired
	LoginDAO ld;
	@Override
	public String ValidateLogin(LoginBean lb) {
		String role=ld.ValidateLogin(lb);
		return role;
	}

}
