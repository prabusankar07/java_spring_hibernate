package com.lms.dao;

import java.util.List;

import com.lms.beans.LabDetailsBean;

public interface LabSearchDao {

	List<LabDetailsBean> LabSearch(LabDetailsBean lb);

	List<LabDetailsBean> LabSearchCity(LabDetailsBean lb);

	List<LabDetailsBean> LabSearchAll(LabDetailsBean lb);

}
