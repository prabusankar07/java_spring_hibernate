package com.lms.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lms.beans.LabDetailsBean;
import com.lms.dao.LabUpdateDAO;
@Component
public class LabUpdateModelImpl implements LabUpdateModel{
	@Autowired
	LabUpdateDAO lad;
	@Override
	public int UpdateLab(LabDetailsBean lb) {
		int result=lad.UpdateLab(lb);
		return result;
	}

}
