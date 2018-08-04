package com.lms.model;

import java.util.List;

import com.lms.beans.LabDetailsBean;

public interface LabSearchModel {

	public List<LabDetailsBean> LabSearch(LabDetailsBean lb) ;

	public List<LabDetailsBean> LabSearchCity(LabDetailsBean lb);

	public List<LabDetailsBean> LabSearchAll(LabDetailsBean lb);

}
