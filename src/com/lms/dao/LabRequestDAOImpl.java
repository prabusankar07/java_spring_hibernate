package com.lms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lms.beans.LabDetailsBean;
import com.lms.beans.LabRequestBean;
import com.lms.entities.LabDetailsBeanEntity;
import com.lms.entities.LabRequestBeanEntity;
@Repository
public class LabRequestDAOImpl implements LabRequestDAO {
	@Autowired
	SessionFactory sf;
	@Override
	@Transactional
	public boolean addLab(LabRequestBean lb) {
		boolean flag = false;
		 Session ses = sf.getCurrentSession();
		 LabRequestBeanEntity lrbe=new LabRequestBeanEntity();
		lrbe.setBookingId(lb.getBookingId());
		lrbe.setLabId(lb.getLabId());
		lrbe.setLabName(lb.getLabName());
		lrbe.setLocation(lb.getLocation());
		lrbe.setLoName(lb.getLoName());
		lrbe.setTrainingName(lb.getTrainingName());
		lrbe.setStartDate(lb.getStartDate());
		lrbe.setEndDate(lb.getEndDate());
		lrbe.setApproval("waiting for approval");
		 try
		 {
		 ses.save(lrbe);
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
	public List<LabRequestBean> LabSearchAll() {
		List<LabRequestBean> li=null;
		Session ses = sf.getCurrentSession();
		LabRequestBeanEntity lbe=new LabRequestBeanEntity();
		 try
		 {
       	 org.hibernate.Query query = ses.createQuery("from LabRequestBeanEntity leb ");
        List<LabRequestBean> result =(List<LabRequestBean>) query.list();
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
	public List<LabRequestBean> LabSearchAll(LabRequestBean lrb) {
		List<LabRequestBean> li=null;
		Session ses = sf.getCurrentSession();
		LabRequestBeanEntity lbe=new LabRequestBeanEntity();
		 try
		 {
       	 org.hibernate.Query query = ses.createQuery("from LabRequestBeanEntity leb where bookingId=:id");
       	query.setParameter("id",lrb.getBookingId());
        List<LabRequestBean> result =(List<LabRequestBean>) query.list();
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
	public int updateLab(LabRequestBean lb) {
		Session ses = sf.getCurrentSession();
		int result=0;
		 try
		 {
        	org.hibernate.Query query = ses.createQuery("update LabRequestBeanEntity leb set approval=:approve where  bookingId=:id");
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