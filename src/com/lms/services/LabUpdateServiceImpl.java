package com.lms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.beans.LabDetailsBean;
import com.lms.model.LabUpdateModel;

@Service
public class LabUpdateServiceImpl implements LabUpdateService {
	@Autowired
	LabUpdateModel lum;
	@Override
	public int UpdateLab(LabDetailsBean lb) {
		int result=lum.UpdateLab(lb);
		return result;
	}

}
