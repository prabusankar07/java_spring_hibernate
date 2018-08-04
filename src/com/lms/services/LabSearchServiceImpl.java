package com.lms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.beans.LabDetailsBean;
import com.lms.model.LabSearchModel;
import com.lms.model.LoginModel;
@Service
public class LabSearchServiceImpl implements LabSearchService{
	@Autowired
	LabSearchModel lsm;
	@Override
	public List<LabDetailsBean> LabSearch(LabDetailsBean lb) {
		
		List<LabDetailsBean> li=lsm.LabSearch(lb);
		return li;
	}
	@Override
	public List<LabDetailsBean> LabSearchCity(LabDetailsBean lb) {
		List<LabDetailsBean> li=lsm.LabSearchCity(lb);
		return li;
	}
	@Override
	public List<LabDetailsBean> LabSearchAll(LabDetailsBean lb) {
		List<LabDetailsBean> li=lsm.LabSearchAll(lb);
		return li;
	}

}
