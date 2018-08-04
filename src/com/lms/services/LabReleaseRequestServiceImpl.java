package com.lms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.beans.LabExtensionRequestBean;
import com.lms.beans.LabReleaseRequestBean;
import com.lms.beans.LabRequestBean;
import com.lms.model.LabReleaseRequestModel;


@Service
public  class LabReleaseRequestServiceImpl implements LabReleaseRequestService {
@Autowired
LabReleaseRequestModel lrm;
@Override
		public boolean requestRelease(LabReleaseRequestBean lb) {
					boolean result= lrm.requestRelease(lb);
				return result;
			}
@Override
public List<LabReleaseRequestBean> LabRequest(){
	List<LabReleaseRequestBean> li =lrm.LabSearchAll();
	return li;
}
	@Override
	public List<LabReleaseRequestBean> LabRequest(LabReleaseRequestBean lrb) {
		List<LabReleaseRequestBean> li=lrm.LabSearchId(lrb);
		return li;
	}

	@Override
	public int updateLab(LabReleaseRequestBean lb) {
		int result= lrm.requestupdate(lb);
		return result;
	}


}
