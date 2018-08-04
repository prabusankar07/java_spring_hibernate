package com.lms.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lms.beans.LabDetailsBean;

public interface LabSearchService {

	List<LabDetailsBean> LabSearch(LabDetailsBean lb);

	List<LabDetailsBean> LabSearchCity(LabDetailsBean lb);

	List<LabDetailsBean> LabSearchAll(LabDetailsBean lb);

	

}
