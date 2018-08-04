package com.lms.dao;

import java.util.List;

import com.lms.beans.LabDetailsBean;
import com.lms.beans.LabRequestBean;

public interface LabRequestDAO {

	
	boolean addLab(LabRequestBean lb);

	List<LabRequestBean> LabSearchAll();

	List<LabRequestBean> LabSearchAll(LabRequestBean lrb);

	int updateLab(LabRequestBean lb);

}
