package com.lms.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lms.beans.LabDetailsBean;
import com.lms.dao.LabSearchDao;
@Component
public class LabSearchModelImpl implements LabSearchModel{
@Autowired
LabSearchDao lsd;
	@Override
	public List<LabDetailsBean> LabSearch(LabDetailsBean lb) {
		// TODO Auto-generated method stub
		List<LabDetailsBean> li=lsd.LabSearch(lb);
		return li;
	}
	@Override
	public List<LabDetailsBean> LabSearchCity(LabDetailsBean lb) {
		List<LabDetailsBean> li=lsd.LabSearchCity(lb);
		return li;
	}
	@Override
	public List<LabDetailsBean> LabSearchAll(LabDetailsBean lb) {
		List<LabDetailsBean> li=lsd.LabSearchAll(lb);
		return li;
	}

}
