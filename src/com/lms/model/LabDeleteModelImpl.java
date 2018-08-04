package com.lms.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lms.beans.LabDetailsBean;
import com.lms.dao.LabDeleteDAO;
@Component
public class LabDeleteModelImpl implements LabDeleteModel{
@Autowired
LabDeleteDAO ldd;
	@Override
	public int deleteLab(LabDetailsBean lb) {
			int result=ldd.deleteLab(lb);
			return result;
	}

}
