package com.lms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lms.beans.LabRequestBean;
import com.lms.beans.LabExtensionRequestBean;
import com.lms.entities.LabExtensionRequestBeanEntity;
import com.lms.entities.LabRequestBeanEntity;

@Repository
public class LabExtensionRequestDAOImpl implements LabExtensionRequestDAO {
	@Autowired
	SessionFactory sf;
	@Override
	@Transactional
	public boolean requestExtend(LabExtensionRequestBean lb) {
		boolean flag = false;
		 Session ses = sf.getCurrentSession();
		 LabExtensionRequestBeanEntity lerbe=new LabExtensionRequestBeanEntity();
			lerbe.setBookingId(lb.getBookingId());
			lerbe.setLabId(lb.getLabId());
			lerbe.setLabName(lb.getLabName());
			lerbe.setLocation(lb.getLocation());
			lerbe.setLoName(lb.getLoName());
			lerbe.setTrainingName(lb.getTrainingName());
			lerbe.setStartDate(lb.getStartDate());
			lerbe.setEndDate(lb.getEndDate());
			lerbe.setExtensionDate(lb.getExtensionDate());
			lerbe.setApproval("waiting for approval");
			try
			 {
			 ses.save(lerbe);
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
	public List<LabExtensionRequestBean> LabSearchAll() {
		List<LabExtensionRequestBean> li=null;
		Session ses = sf.getCurrentSession();
		LabExtensionRequestBeanEntity lbe=new LabExtensionRequestBeanEntity();
		 try
		 {
       	 org.hibernate.Query query = ses.createQuery("from LabExtensionRequestBeanEntity leb ");
        List<LabExtensionRequestBean> result =(List<LabExtensionRequestBean>) query.list();
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
	public List<LabExtensionRequestBean> LabSearchAll(LabExtensionRequestBean lrb) {
		List<LabExtensionRequestBean> li=null;
		Session ses = sf.getCurrentSession();
		LabExtensionRequestBeanEntity lbe=new LabExtensionRequestBeanEntity();
		 try
		 {
       	 org.hibernate.Query query = ses.createQuery("from LabExtensionRequestBeanEntity leb where bookingId=:id");
       	query.setParameter("id",lrb.getBookingId());
        List<LabExtensionRequestBean> result =(List<LabExtensionRequestBean>) query.list();
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
	public int updateLab(LabExtensionRequestBean lb) {
		Session ses = sf.getCurrentSession();
		int result=0;
		 try
		 {
        	org.hibernate.Query query = ses.createQuery("update LabExtensionRequestBeanEntity leb set approval=:approve where  bookingId=:id");
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
