package com.lms.services;

import java.util.List;

import com.lms.beans.LabDetailsBean;
import com.lms.beans.LabRequestBean;

public interface LabRequestService {

	boolean addLab(LabRequestBean lb);
	
	List<LabRequestBean> LabRequest();

	List<LabRequestBean> LabRequest(LabRequestBean lrb);

	int updateLab(LabRequestBean lb);

	List<LabRequestBean> addLab1(LabRequestBean lb);

}

