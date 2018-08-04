package com.lms.dao;


import java.util.List;

import com.lms.beans.LabExtensionRequestBean;
import com.lms.beans.LabRequestBean;
import com.lms.beans.LabReleaseRequestBean;

public interface LabReleaseRequestDAO {
	boolean requestRelease(LabReleaseRequestBean lb);
	List<LabReleaseRequestBean> LabSearchAll();

	List<LabReleaseRequestBean> LabSearchAll(LabReleaseRequestBean lrb);

	int updateLab(LabReleaseRequestBean lb);

}
