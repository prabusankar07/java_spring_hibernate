package com.lms.model;

import java.util.List;

import com.lms.beans.LabExtensionRequestBean;
import com.lms.beans.LabRequestBean;
import com.lms.beans.LabReleaseRequestBean;

public interface LabReleaseRequestModel {
	
	boolean requestRelease(LabReleaseRequestBean lb);
	List<LabReleaseRequestBean> LabSearchAll();

	List<LabReleaseRequestBean> LabSearchId(LabReleaseRequestBean lrb);

	int requestupdate(LabReleaseRequestBean lb);


}
