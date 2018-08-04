package com.lms.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lms.beans.LabDetailsBean;
import com.lms.beans.LabRequestBean;
import com.lms.dao.LabRequestDAO;
@Component 
public class LabRequestModelImpl implements LabRequestModel{
@Autowired
LabRequestDAO lrd;

	@Override
	public boolean request(LabRequestBean lb) {
		boolean result= lrd.addLab(lb);
		return result;
	}

	@Override
	public List<LabRequestBean> LabSearchAll() {
		List<LabRequestBean> li=lrd.LabSearchAll();
		return li;
	}

	@Override
	public List<LabRequestBean> LabSearchId(LabRequestBean lrb) {
		List<LabRequestBean> li=lrd.LabSearchAll(lrb);
		return li;
	}

	@Override
	public int requestupdate(LabRequestBean lb) {
		int result= lrd.updateLab(lb);
		return result;
	}

}
