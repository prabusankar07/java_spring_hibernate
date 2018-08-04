package com.lms.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lms.beans.LabRequestBean;
import com.lms.beans.LabExtensionRequestBean;
import com.lms.dao.LabExtensionRequestDAO;

@Component 
public class LabExtensionRequestModelImpl implements LabExtensionRequestModel {
	@Autowired
	LabExtensionRequestDAO lrd;

		@Override
		public boolean requestExtend(LabExtensionRequestBean lb) {
			boolean result= lrd.requestExtend(lb);
			return result;
		}
		@Override
		public List<LabExtensionRequestBean> LabSearchAll() {
			List<LabExtensionRequestBean> li=lrd.LabSearchAll();
			return li;
		}

		@Override
		public List<LabExtensionRequestBean> LabSearchId(LabExtensionRequestBean lrb) {
			List<LabExtensionRequestBean> li=lrd.LabSearchAll(lrb);
			return li;
		}

		@Override
		public int requestupdate(LabExtensionRequestBean lb) {
			int result= lrd.updateLab(lb);
			return result;
		}

}
