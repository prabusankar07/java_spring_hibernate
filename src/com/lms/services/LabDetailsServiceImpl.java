package com.lms.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.beans.LabDetailsBean;
import com.lms.model.LabDetailsModel;
@Service
public class LabDetailsServiceImpl implements LabDetailsService {
	@Autowired
	LabDetailsModel lm;
	
	@Override
	public boolean addLab(LabDetailsBean lb) {
		
		boolean result= lm.addLab(lb);
		System.out.println("result is .. " + result);
		return result;
		 
	}

}
