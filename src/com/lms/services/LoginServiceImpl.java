package com.lms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.beans.LoginBean;
import com.lms.model.LoginModel;
@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginModel lm;
	
	@Override
	public String ValidateLogin(LoginBean lb) {
	
		String role=lm.ValidateLogin(lb);
		return role;
	}

}
