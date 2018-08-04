package com.lms.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lms.beans.LabDetailsBean;
import com.lms.entities.LabDetailsBeanEntity;
@Repository
public class LabDetailsDAOImpl implements LabDetailsDAO{
	@Autowired
	SessionFactory sf;
	@Override
	@Transactional
public boolean addLab(LabDetailsBean lb) {
		
		boolean flag = false;
		 Session ses = sf.getCurrentSession();
		        
		LabDetailsBeanEntity alde  = new LabDetailsBeanEntity();
		alde.setLabId(lb.getLabId());
		alde.setType(lb.getType());
		alde.setCountry(lb.getCountry());
		alde.setCity(lb.getCity());
		alde.setCapacity(lb.getCapacity());
		alde.setStatus(lb.getStatus());
		alde.setProjector(lb.getProjector());
		alde.setPhone(lb.getPhone());
		alde.setMike(lb.getMike());
		alde.setSoundSystem(lb.getSoundSystem());
		alde.setVideoConference(lb.getVideoConference());
		alde.setSystemsAvailable(lb.getSystemsAvailable());
		alde.setWhiteBoard(lb.getWhiteBoard());
		alde.setAirConditioner(lb.getAirConditioner());
		alde.setLabName(lb.getLabName());
		
		try
		 {
		 ses.save(alde);
		 flag = true;
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		 System.out.println("returning flag .. " + flag);

		 return flag;
		        
	}
		
}

