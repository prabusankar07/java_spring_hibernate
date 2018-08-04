package com.lms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lms.beans.LabDetailsBean;
@Repository
public class LabUpdateDAOImpl implements LabUpdateDAO{

	@Autowired
	SessionFactory sf;
	@Override
	@Transactional
	public int UpdateLab(LabDetailsBean lb) {
		Session ses = sf.getCurrentSession();
		int result=0;
		System.out.println(lb.getLabId());
		 try
		 {
        	org.hibernate.Query query = ses.createQuery("update LabDetailsBeanEntity leb set labName=:labname,type=:type,country=:country,city=:city,capacity=:capacity,status=:status,projector=:projector,phone=:phone,mike=:mike,soundSystem=:soundSystem,videoConference=:videoConference,airConditioner=:airConditioner,whiteBoard=:whiteBoard,systemsAvailable=:systemsAvailable where labId=:id");
        	query.setParameter("id",lb.getLabId());
        	query.setParameter("labname",lb.getLabName());
        	query.setParameter("type",lb.getType());
        	query.setParameter("country",lb.getCountry());
        	query.setParameter("city",lb.getCity());
        	query.setParameter("capacity",lb.getCapacity());
        	query.setParameter("status",lb.getStatus());
        	query.setParameter("mike",lb.getMike());
        	query.setParameter("projector",lb.getProjector());
        	query.setParameter("phone",lb.getPhone());
        	query.setParameter("soundSystem",lb.getSoundSystem());
        	query.setParameter("videoConference",lb.getVideoConference());
        	query.setParameter("airConditioner",lb.getAirConditioner());
        	query.setParameter("whiteBoard",lb.getWhiteBoard());
        	query.setParameter("systemsAvailable",lb.getSystemsAvailable());
        	result = query.executeUpdate();
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
			return result;
		
	}

}
