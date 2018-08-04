package com.lms.model;

import com.lms.beans.LabDetailsBean;
import com.lms.beans.LabRequestBean;
import java.util.List;

public interface LabRequestModel {

	boolean request(LabRequestBean lb);

	List<LabRequestBean> LabSearchAll();

	List<LabRequestBean> LabSearchId(LabRequestBean lrb);

	int requestupdate(LabRequestBean lb);


}
