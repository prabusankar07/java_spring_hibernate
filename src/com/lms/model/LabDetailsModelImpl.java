package com.lms.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lms.beans.LabDetailsBean;
import com.lms.dao.LabDetailsDAO;

@Component
public class LabDetailsModelImpl implements LabDetailsModel {

	@Autowired
	LabDetailsDAO ld;
	
	@Override
	@Transactional
	public boolean addLab(LabDetailsBean lb) {
		boolean result =  ld.addLab(lb);
		System.out.println("result is " + result);
		return result;
	}

}
