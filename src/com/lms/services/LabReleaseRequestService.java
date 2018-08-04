package com.lms.services;

import java.util.List;

import com.lms.beans.LabExtensionRequestBean;
import com.lms.beans.LabReleaseRequestBean;
import com.lms.beans.LabRequestBean;

public interface LabReleaseRequestService {
	
	boolean requestRelease(LabReleaseRequestBean lb);
	List<LabReleaseRequestBean> LabRequest();
	List<LabReleaseRequestBean> LabRequest(LabReleaseRequestBean lrb);
	int updateLab(LabReleaseRequestBean lb);


}