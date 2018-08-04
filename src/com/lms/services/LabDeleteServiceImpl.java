package com.lms.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.beans.LabDetailsBean;
import com.lms.model.LabDeleteModel;


@Service
public class LabDeleteServiceImpl implements LabDeleteService {
	@Autowired
	LabDeleteModel ldm;
	@Override
	public int deleteLab(LabDetailsBean lb) {
		int result=ldm.deleteLab(lb);
		return result;
	}

}
