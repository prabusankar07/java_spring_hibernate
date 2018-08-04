package com.lms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.beans.LabExtensionRequestBean;
import com.lms.beans.LabRequestBean;
import com.lms.model.LabExtensionRequestModel;


@Service
public  class LabExtensionRequestServiceImpl implements LabExtensionRequestService {
@Autowired
LabExtensionRequestModel lrm;
@Override
		public boolean requestExtend(LabExtensionRequestBean lb) {
					boolean result= lrm.requestExtend(lb);
				return result;
			}
@Override
public List<LabExtensionRequestBean> LabRequest(){
	List<LabExtensionRequestBean> li =lrm.LabSearchAll();
	return li;
}
	@Override
	public List<LabExtensionRequestBean> LabRequest(LabExtensionRequestBean lrb) {
		List<LabExtensionRequestBean> li=lrm.LabSearchId(lrb);
		return li;
	}

	@Override
	public int updateLab(LabExtensionRequestBean lb) {
		int result= lrm.requestupdate(lb);
		return result;
	}
}


