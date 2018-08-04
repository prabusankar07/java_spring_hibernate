package com.lms.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lms.beans.LabExtensionRequestBean;
import com.lms.beans.LabRequestBean;
import com.lms.beans.LabReleaseRequestBean;
import com.lms.dao.LabReleaseRequestDAO;

@Component 
public class LabReleaseRequestModelImpl implements LabReleaseRequestModel {
	@Autowired
	LabReleaseRequestDAO lrd;

		@Override
		public boolean requestRelease(LabReleaseRequestBean lb) {
			boolean result= lrd.requestRelease(lb);
			return result;
		}
		@Override
		public List<LabReleaseRequestBean> LabSearchAll() {
			List<LabReleaseRequestBean> li=lrd.LabSearchAll();
			return li;
		}

		@Override
		public List<LabReleaseRequestBean> LabSearchId(LabReleaseRequestBean lrb) {
			List<LabReleaseRequestBean> li=lrd.LabSearchAll(lrb);
			return li;
		}

		@Override
		public int requestupdate(LabReleaseRequestBean lb) {
			int result= lrd.updateLab(lb);
			return result;
		}

}
