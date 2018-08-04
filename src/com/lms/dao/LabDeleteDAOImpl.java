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
public class LabDeleteDAOImpl implements LabDeleteDAO {

	@Autowired
	SessionFactory sf;
	@Override
	@Transactional
	public int deleteLab(LabDetailsBean lb) {
		Session ses = sf.getCurrentSession();
		int result=0;
		System.out.println(lb.getLabId());
		LabDetailsBeanEntity lbe=new LabDetailsBeanEntity();
		 try
		 {
        	org.hibernate.Query query = ses.createQuery("delete LabDetailsBeanEntity leb where labId=:id");
        	query.setParameter("id",lb.getLabId());
        	result = query.executeUpdate();
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
			return result;
		
	}

}
