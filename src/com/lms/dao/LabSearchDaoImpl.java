package com.lms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lms.beans.LabDetailsBean;
import com.lms.entities.LabDetailsBeanEntity;
import com.lms.entities.LoginBeanEntity;
@Repository
public class LabSearchDaoImpl implements LabSearchDao{
	@Autowired
	SessionFactory sf;
	@Override
	@Transactional
	public List<LabDetailsBean> LabSearch(LabDetailsBean lb) {
		List<LabDetailsBean> li=null;
		Session ses = sf.getCurrentSession();
		LabDetailsBeanEntity lbe=new LabDetailsBeanEntity();
		 try
		 {
        	org.hibernate.Query query = ses.createQuery("from LabDetailsBeanEntity leb where labId=:id");
        	query.setParameter("id",lb.getLabId());
        	List<LabDetailsBean> result =(List<LabDetailsBean>) query.list();
		 if(result.isEmpty()==false)
		 {
			 li=result;
		 }
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return li;
	}
	@Override
	@Transactional
		public List<LabDetailsBean> LabSearchCity(LabDetailsBean lb) {
			List<LabDetailsBean> li=null;
			Session ses = sf.getCurrentSession();
			System.out.println(lb.getCity());
			System.out.println((lb.getSystemsAvailable()));
			LabDetailsBeanEntity lbe=new LabDetailsBeanEntity();
			 try
			 {
	        	org.hibernate.Query query = ses.createQuery("from LabDetailsBeanEntity leb where city=:id");
	        	query.setParameter("id",lb.getCity());
	        	System.out.println(lbe.getSystemsAvailable());
	       List<LabDetailsBean> result =(List<LabDetailsBean>) query.list();
			 if(result.isEmpty()==false)
			 {
				 li=result;
			 }
			 }catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			return li;
	}
	@Override
	@Transactional
	public List<LabDetailsBean> LabSearchAll(LabDetailsBean lb) {
			List<LabDetailsBean> li=null;
			Session ses = sf.getCurrentSession();
			System.out.println(lb.getCity());
			LabDetailsBeanEntity lbe=new LabDetailsBeanEntity();
			 try
			 {
	       	 org.hibernate.Query query = ses.createQuery("from LabDetailsBeanEntity leb ");
	        List<LabDetailsBean> result =(List<LabDetailsBean>) query.list();
			 if(result.isEmpty()==false)
			 {
				 li=result;
			 }
			 }catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			return li;
	}
	}

	
