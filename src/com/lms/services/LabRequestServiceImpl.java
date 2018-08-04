package com.lms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.beans.LabDetailsBean;
import com.lms.beans.LabRequestBean;
import com.lms.model.LabRequestModel;

@Service
public class LabRequestServiceImpl implements LabRequestService{
@Autowired
LabRequestModel lrm;
	
	@Override
	public boolean addLab(LabRequestBean lb) {
			boolean result= lrm.request(lb);
			return result;
		}
	
	@Override
	public List<LabRequestBean> LabRequest() {
		List<LabRequestBean> li=lrm.LabSearchAll();
		return li;
	}

	@Override
	public List<LabRequestBean> LabRequest(LabRequestBean lrb) {
		List<LabRequestBean> li=lrm.LabSearchId(lrb);
		return li;
	}

	@Override
	public int updateLab(LabRequestBean lb) {
		int result= lrm.requestupdate(lb);
		return result;
	}

	@Override
	public List<LabRequestBean> addLab1(LabRequestBean lb) {
	
		List<LabRequestBean> li=lrm.LabSearchId(lb);
		return li;
		
		
	}


}
