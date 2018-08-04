package com.lms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lms.beans.LoginBean;
import com.lms.entities.LoginBeanEntity;
@Repository

public class LoginDAOImpl implements LoginDAO {
	@Autowired
	SessionFactory sf;

	@Override
	@Transactional
	public String ValidateLogin(LoginBean lb) {
		String role="null";
		Session ses = sf.getCurrentSession();
        System.out.println(lb.getUserName());
        System.out.println(lb.getPassword());
    		
        try
		 {
        	org.hibernate.Query query = ses.createQuery("from LoginBeanEntity lbe where lbe.userName=:uname And lbe.password=:pass");
        	query.setParameter("uname",lb.getUserName());
        	query.setParameter("pass",lb.getPassword());
        	List<LoginBeanEntity> result =(List<LoginBeanEntity>) query.list();
        	for(LoginBeanEntity lb1: result )
    		{
        		role=lb1.getRole();
    		}		
        	
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		System.out.println(role);
        return role;
	}

}
