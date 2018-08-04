package com.lms.dao;

import java.util.List;

import com.lms.beans.LabRequestBean;
import com.lms.beans.LabExtensionRequestBean;

public interface LabExtensionRequestDAO {
	
	boolean requestExtend(LabExtensionRequestBean lb);
	List<LabExtensionRequestBean> LabSearchAll();

	List<LabExtensionRequestBean> LabSearchAll(LabExtensionRequestBean lrb);

	int updateLab(LabExtensionRequestBean lb);

}
