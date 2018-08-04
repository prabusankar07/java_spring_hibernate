package com.lms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.lms.beans.LabExtensionRequestBean;
import com.lms.beans.LabRequestBean;
import com.lms.beans.LabReleaseRequestBean;
import com.lms.entities.LabExtensionRequestBeanEntity;
import com.lms.entities.LabReleaseRequestBeanEntity;
import com.lms.entities.LabRequestBeanEntity;

@Repository
public class LabReleaseRequestDAOImpl implements LabReleaseRequestDAO {
	@Autowired
	SessionFactory sf;
	@Override
	@Transactional
	public boolean requestRelease(LabReleaseRequestBean lb) {
		boolean flag = false;
		 Session ses = sf.getCurrentSession();
		 LabReleaseRequestBeanEntity lrrbe=new LabReleaseRequestBeanEntity();
			lrrbe.setBookingId(lb.getBookingId());
			lrrbe.setLabId(lb.getLabId());
			lrrbe.setLabName(lb.getLabName());
			lrrbe.setLocation(lb.getLocation());
			lrrbe.setLoName(lb.getLoName());
			lrrbe.setTrainingName(lb.getTrainingName());
			lrrbe.setStartDate(lb.getStartDate());
			lrrbe.setEndDate(lb.getEndDate());
			lrrbe.setReleaseDate(lb.getReleaseDate());
			lrrbe.setApproval("waiting for approval");
			try
			 {
			 ses.save(lrrbe);
			 flag = true;
			 }catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			 
			 System.out.println("returning flag .. " + flag);

			 return flag;

}
	@Override
	@Transactional
	public List<LabReleaseRequestBean> LabSearchAll() {
		List<LabReleaseRequestBean> li=null;
		Session ses = sf.getCurrentSession();
		LabReleaseRequestBeanEntity lbe=new LabReleaseRequestBeanEntity();
		 try
		 {
       	 org.hibernate.Query query = ses.createQuery("from LabReleaseRequestBeanEntity leb ");
        List<LabReleaseRequestBean> result =(List<LabReleaseRequestBean>) query.list();
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
	@Transactional
	@Override
	public List<LabReleaseRequestBean> LabSearchAll(LabReleaseRequestBean lrb) {
		List<LabReleaseRequestBean> li=null;
		Session ses = sf.getCurrentSession();
		LabReleaseRequestBeanEntity lbe=new LabReleaseRequestBeanEntity();
		 try
		 {
       	 org.hibernate.Query query = ses.createQuery("from LabReleaseRequestBeanEntity leb where bookingId=:id");
       	query.setParameter("id",lrb.getBookingId());
        List<LabReleaseRequestBean> result =(List<LabReleaseRequestBean>) query.list();
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
	public int updateLab(LabReleaseRequestBean lb) {
		Session ses = sf.getCurrentSession();
		int result=0;
		 try
		 {
        	org.hibernate.Query query = ses.createQuery("update LabReleaseRequestBeanEntity leb set approval=:approve where  bookingId=:id");
          	query.setParameter("id",lb.getBookingId());
        	query.setParameter("approve",lb.getApproval());
        	result = query.executeUpdate();
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
			return result;
		
	}
}
