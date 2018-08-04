package com.lms.model;

import java.util.List;

import com.lms.beans.LabRequestBean;
import com.lms.beans.LabExtensionRequestBean;

public interface LabExtensionRequestModel {
	
	boolean requestExtend(LabExtensionRequestBean lb);
	List<LabExtensionRequestBean> LabSearchAll();

	List<LabExtensionRequestBean> LabSearchId(LabExtensionRequestBean lrb);

	int requestupdate(LabExtensionRequestBean lb);


}
