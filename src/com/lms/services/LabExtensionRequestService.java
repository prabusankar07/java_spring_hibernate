package com.lms.services;

import java.util.List;

import com.lms.beans.LabExtensionRequestBean;
import com.lms.beans.LabRequestBean;

public interface LabExtensionRequestService {
	
	boolean requestExtend(LabExtensionRequestBean lb);
	List<LabExtensionRequestBean> LabRequest();
	List<LabExtensionRequestBean> LabRequest(LabExtensionRequestBean lerb);
	int updateLab(LabExtensionRequestBean lb);

}
