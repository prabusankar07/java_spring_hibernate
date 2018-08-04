package com.lms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lms.beans.LabDetailsBean;
import com.lms.beans.LabExtensionRequestBean;
import com.lms.beans.LabReleaseRequestBean;
import com.lms.beans.LabRequestBean;
import com.lms.beans.LoginBean;

import com.lms.services.LabSearchService;
//import com.lms.services.LabSearchService;
import com.lms.services.LabDeleteService;
import com.lms.services.LabExtensionRequestService;
import com.lms.services.LabReleaseRequestService;
import com.lms.services.LabRequestService;
import com.lms.services.LabUpdateService;
import com.lms.services.LoginService;
import com.lms.services.LabDetailsService;

@Controller
public class LMSController {
	@Autowired
	LoginService ls;

	
	@RequestMapping(value="LoginPage")
	public ModelAndView generateLoginPage()
	{
		LoginBean obj = new LoginBean();
		ModelAndView mv = new ModelAndView("LoginPage","lb",obj);
		return mv;
		
	}
	@RequestMapping(value="login",method=RequestMethod.POST)
	public ModelAndView lmsLogin(@ModelAttribute(value="lb")LoginBean lb)
	{
		ModelAndView mv = new ModelAndView();
		String role=null; 
		try
	       {
				      System.out.println(lb.getUserName());
	      role = ls.ValidateLogin(lb);
	       }catch(Exception e)
	       {
	    	   System.out.println(e.getMessage());
	       }
		 if(role.equals("LO"))
	       {
	       mv.setViewName("HomeLO");
	      mv.addObject("user",lb.getUserName());
	
	       mv.addObject("ldata",lb);
	       }else if(role.equals("OTH"))
	       {
	    	   mv.setViewName("HomeOTH");
	    	 mv.addObject("user",lb.getUserName());
	       	   mv.addObject("ldata",lb);
	       }else if(role.equals("OTM"))
	       {
	    	   mv.setViewName("HomeOTM");
	    	   mv.addObject("ldata",lb);
	       }else if(role.equals("null"))
	       {
	    	   mv.setViewName("LoginPage");
	    	   mv.addObject("errmsg","Server Error !");
	       }
	       
		return mv;
		
	}
	@RequestMapping(value="Home")
	public ModelAndView generatehomePage(HttpSession session)
	{
		ModelAndView mv;
		 if(session==null ||session.isNew())
		 {
			 mv = new ModelAndView("Expired");
		}
		 else{
		 mv = new ModelAndView("HomeOTH");
		 }
		return mv;
		
	}
	@RequestMapping(value="HomeLO")
	public ModelAndView generatehomeLoPage(HttpSession session)
	{   
		ModelAndView mv;
		 if(session==null ||session.isNew())
		 {
			 mv = new ModelAndView("Expired");
		}
		 else{
	    mv = new ModelAndView("HomeLO");
		 }
		return mv;
		
	}
	@RequestMapping(value="Logout")
	public ModelAndView generatelogoutPage(HttpSession session)
	{
		ModelAndView mv;
		 if(session==null ||session.isNew())
		 {
			 mv = new ModelAndView("Expired");
		}
		 else{
		 mv = new ModelAndView("Logout");
		 }
		return mv;
		
	}
	@Autowired
	LabSearchService lss;
	@RequestMapping(value="LabSearch")
	public ModelAndView generateSearchPage(HttpSession session)
	{
		ModelAndView mv;
		 if(session==null ||session.isNew())
		 {
			 mv = new ModelAndView("Expired");
		}
		 else{
		LabDetailsBean ldb = new LabDetailsBean();
	    mv = new ModelAndView("LabSearchOTH","lb",ldb);
		 }
		return mv;
	}
	@RequestMapping(value="LabSearchLO")
	public ModelAndView generatPage(HttpSession session)
	{
		ModelAndView mv;
		 if(session==null ||session.isNew())
		 {
			 mv = new ModelAndView("Expired");
		}
		 else{
		LabDetailsBean ldb = new LabDetailsBean();
	    mv = new ModelAndView("LabSearchLO","lb",ldb);
		 }
		return mv;
	}
		@RequestMapping(value="searchIDLO")
	public ModelAndView lmsSearchIDLO(@ModelAttribute(value="lb")LabDetailsBean lb,HttpSession session)
	{   
			ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else {
		 mv = new ModelAndView();
		List<LabDetailsBean> li=null;
		try
	       {
	        li = lss.LabSearch(lb);
	       }catch(Exception e)
	       {
	    	   System.out.println(e.getMessage());
	       }
		if( li==null)
		{
			 mv.setViewName("LabSearchLO");
	    	 mv.addObject("errmsg","Server Error !");
		}
		else
		{
			 mv.setViewName("SearchResultsLO");
			 mv.addObject("search",li);
		}
	}
		return mv;
		
	}
		@RequestMapping(value="SearchCityLO")
		public ModelAndView lmsSearchCityLO(@ModelAttribute(value="lb")LabDetailsBean lb,HttpSession session )
		{   
			 ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else {
			mv = new ModelAndView();
			List<LabDetailsBean> li=null;
			try
		       {
		        li = lss.LabSearchCity(lb);
		       }catch(Exception e)
		       {
		    	   System.out.println(e.getMessage());
		       }
			if(li==null)
			{
				 mv.setViewName("LabSearchLO");
		    	 mv.addObject("errmsg","Server Error !");
			}
			else
			{
				mv.setViewName("SearchResultsLO");
				 mv.addObject("search",li);
			}
		}
			return mv;
			
		}
		@RequestMapping(value="SearchAllLO")
		public ModelAndView lmsSearchAllLO(@ModelAttribute(value="lb")LabDetailsBean lb,HttpSession session )
		{    
			ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else {
			mv = new ModelAndView();
			List<LabDetailsBean> li=null;
			try
		       {
		        li = lss.LabSearchAll(lb);
		       }catch(Exception e)
		       {
		    	   System.out.println(e.getMessage());
		       }
			if(li==null)
			{
				 mv.setViewName("LabSearchLO");
		    	 mv.addObject("errmsg","Server Error !");
			}
			else
			{
				mv.setViewName("SearchResultsLO");
				 mv.addObject("search",li);
			}
		}
			return mv;
		}
		@RequestMapping(value="searchID")
		public ModelAndView lmsSearchID(@ModelAttribute(value="lb")LabDetailsBean lb,HttpSession session)
		{   
				ModelAndView mv;
				 if(session==null ||session.isNew())
				 {
					 mv = new ModelAndView("Expired");
				}
				 else {
			 mv = new ModelAndView();
			List<LabDetailsBean> li=null;
			try
		       {
		        li = lss.LabSearch(lb);
		       }catch(Exception e)
		       {
		    	   System.out.println(e.getMessage());
		       }
			if( li==null)
			{
				 mv.setViewName("LabSearchOTH");
		    	 mv.addObject("errmsg","Server Error !");
			}
			else
			{
				 mv.setViewName("SearchResultsOTH");
				 mv.addObject("search",li);
			}
		}
			return mv;
			
		}
			@RequestMapping(value="SearchCity")
			public ModelAndView lmsSearchCity(@ModelAttribute(value="lb")LabDetailsBean lb,HttpSession session )
			{   
				 ModelAndView mv;
				 if(session==null ||session.isNew())
				 {
					 mv = new ModelAndView("Expired");
				}
				 else {
				mv = new ModelAndView();
				List<LabDetailsBean> li=null;
				try
			       {
			        li = lss.LabSearchCity(lb);
			       }catch(Exception e)
			       {
			    	   System.out.println(e.getMessage());
			       }
				if(li==null)
				{
					 mv.setViewName("LabSearchOTH");
			    	 mv.addObject("errmsg","Server Error !");
				}
				else
				{
					mv.setViewName("SearchResultsOTH");
					 mv.addObject("search",li);
				}
			}
				return mv;
				
			}
			@RequestMapping(value="SearchAll")
			public ModelAndView lmsSearchAll(@ModelAttribute(value="lb")LabDetailsBean lb,HttpSession session )
			{    
				ModelAndView mv;
				 if(session==null ||session.isNew())
				 {
					 mv = new ModelAndView("Expired");
				}
				 else {
				mv = new ModelAndView();
				List<LabDetailsBean> li=null;
				try
			       {
			        li = lss.LabSearchAll(lb);
			       }catch(Exception e)
			       {
			    	   System.out.println(e.getMessage());
			       }
				if(li==null)
				{
					 mv.setViewName("LabSearchOTH");
			    	 mv.addObject("errmsg","Server Error !");
				}
				else
				{
					mv.setViewName("SearchResultsOTH");
					 mv.addObject("search",li);
				}
			}
				return mv;
			}
		
		// for delete a lab from labdetails
		
		
		@Autowired
		LabDeleteService ldds;
		
		@RequestMapping(value="delete")
		public ModelAndView generateDeletePage(HttpSession session)
		{   
			ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else{
			System.out.println("hello");
			LabDetailsBean ldb = new LabDetailsBean();
			mv = new ModelAndView("DeactivateLab","lb",ldb);
		}
			return mv;
			
		}
		@RequestMapping(value="labDelete")
		public ModelAndView LabDelete(@ModelAttribute(value="lb")LabDetailsBean lb ,HttpSession session)
		{   
			ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else{
			mv = new ModelAndView();
			List<LabDetailsBean> li=null;
			LabDetailsBean ldb = new LabDetailsBean();
			try
		       {
		        li = lss.LabSearch(lb);
		       }catch(Exception e)
		       {
		    	   System.out.println(e.getMessage());
		       }
			if(li==null)
			{
				 mv.setViewName("DeactivateLab");
		    	 mv.addObject("errmsg","Server Error !");
			}
			else
			{
				mv.setViewName("Deactivate");
				 mv.addObject("search",li);
				 mv.addObject("lb",ldb);
			}
			 }
			return mv;
			
		}
		@RequestMapping(value="DeleteEntry")
		public ModelAndView LabDeleteEntry(@ModelAttribute(value="lb")LabDetailsBean lb,HttpSession session )
		{   
			ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else{
			mv = new ModelAndView();
			int result=0;
			LabDetailsBean ldb = new LabDetailsBean();
			try
		       {
		        result = ldds.deleteLab(lb);
		       }catch(Exception e)
		       {
		    	   System.out.println(e.getMessage());
		       }
			if(result==0)
			{
				 mv.setViewName("DeactivateLab");
		    	 mv.addObject("err","Server Error !");
			}
			else
			{
				mv.setViewName("DeactivateLab");
				 mv.addObject("lb",ldb);
				 mv.addObject("success","deleted");
			}
			 }
			return mv;
			
		}
		
		//for update a lab
		
		@Autowired
		LabUpdateService lus;
		@RequestMapping(value="Update")
		public ModelAndView generateUpdatePage(HttpSession session)
		{
			ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else{
			LabDetailsBean ldb = new LabDetailsBean();
			mv = new ModelAndView("UpdateOTH","lb",ldb);
			 }
			return mv;
		}
		
		// for update a lab details
		
		@RequestMapping(value="labUpdate")
		public ModelAndView LabUpdate(@ModelAttribute(value="ldb")LabDetailsBean lb, HttpSession session)
		{
			ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else{
			 mv = new ModelAndView();
			List<LabDetailsBean> li=null;
			LabDetailsBean ldb = new LabDetailsBean();
			try
		       {
		        li = lss.LabSearch(lb);
		       }catch(Exception e)
		       {
		    	   System.out.println(e.getMessage());
		       }
			if(li==null)
			{
				 mv.setViewName("UpdateOTH");
		    	 mv.addObject("errmsg","Server Error !");
			}
			else
			{
				mv.setViewName("UpdateLabDetailsOTH");
				 mv.addObject("search",li);
				 mv.addObject("lb",ldb);
			}
			 }	
			return mv;
			
		}
		
		@RequestMapping(value="UpdateEntry")
		public ModelAndView LabUpdateEntry(@ModelAttribute(value="lb")LabDetailsBean lb,HttpSession session)
		{
			ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else{
			 mv = new ModelAndView();
			LabDetailsBean ldb = new LabDetailsBean();
			int result=0;
			try
		       {
		        result = lus.UpdateLab(lb);
		       }catch(Exception e)
		       {
		    	   System.out.println(e.getMessage());
		       }
			if(result==0)
			{
				 mv.setViewName("UpdateOTH");
		    	 mv.addObject("err","Server Error !");
			}
			else
			{
				mv.setViewName("UpdateOTH");
				 mv.addObject("lb",ldb);
				 mv.addObject("success","updated");
			}
			 }
			return mv;
			
		}
		// for add lab details
		@Autowired
		LabDetailsService lds;
		@RequestMapping(value="AddLabDetails")
		public ModelAndView generateAddLabPage(HttpSession session)
		{   
			ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else{
			System.out.println("inside add lab");
			LabDetailsBean obj = new LabDetailsBean();
		    mv = new ModelAndView("AddLabDetails","sb",obj);
			System.out.println("inside add lab2");
			}
			return mv;
			
		}
		@RequestMapping(value="AddLab",method=RequestMethod.POST)
		public ModelAndView addLab(@ModelAttribute(value="sb")LabDetailsBean lb,HttpSession session)
		{   
			ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else{
			System.out.println("inside add");
			mv=new ModelAndView();
			boolean temp=false;
			try
			{
			      temp = lds.addLab(lb);
			}
			catch(Exception e)
			{
			e.printStackTrace();
			}
			 if(temp)
		       {
		       mv.setViewName("Success");
		       mv.addObject("sb",lb);
		       mv.addObject("success","inserted");
		       
		       }
			 else
		       {
		    	   mv.setViewName("AddLabDetails");
		    	   mv.addObject("errmsg","Server Error !");
		       }
		       
			 }
		       
		       return mv;
		}
		
		// for requesting a lab
		
		@Autowired
		LabRequestService lrs;
		@RequestMapping(value="LabRequest")
		public ModelAndView generateRequestPage(HttpSession session)
		{
			ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else{
			
			LabDetailsBean ldb = new LabDetailsBean();
			mv = new ModelAndView("LabRequest","lb",ldb);
			 }
			return mv;
		}
		@RequestMapping(value="LabRequestSearch")
		public ModelAndView LabRequest(@ModelAttribute(value="lb")LabDetailsBean lb,HttpSession session)
		{
			ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else{
			 mv = new ModelAndView();
			List<LabDetailsBean> li=null;
			LabRequestBean ldb = new LabRequestBean();
			
			try
		       {
		        li = lss.LabSearch(lb);
		       }catch(Exception e)
		       {
		    	   System.out.println(e.getMessage());
		       }
			if(li==null)
			{
				 mv.setViewName("LabRequest");
		    	 mv.addObject("errmsg","Server Error !");
			}
			else
			{
				mv.setViewName("LabRequest");
				 mv.addObject("search",li);
				 mv.addObject("lb",ldb);
			}
		}
			return mv;
			
		}
		@RequestMapping(value="LabRequestEntry")
		public ModelAndView LabRequestEntry(@ModelAttribute(value="lb")LabRequestBean lb,HttpSession session)
		{   
			ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else{
			mv=new ModelAndView();
			boolean temp=false;
			try
			{
			      temp = lrs.addLab(lb);
			}
			catch(Exception e)
			{
			e.printStackTrace();
			}
			 if(temp)
		       {
		       mv.setViewName("SuccessLO");
		       mv.addObject("sb",lb);
		       }
			 else
		       {
		    	   mv.setViewName("Error");
		    	   mv.addObject("errmsg","Server Error !");
		       }
			 }
			return mv;
		       
		}
		@Autowired
		LabExtensionRequestService lers;
		@RequestMapping(value="LabExtensionRequest")
		public ModelAndView generateExtensionRequestPage(HttpSession session)
		{   
			ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else{
			LabExtensionRequestBean ledb = new LabExtensionRequestBean();
			 mv = new ModelAndView("LabExtensionRequest","lb1",ledb);
			 }
			return mv;
		}
		@RequestMapping(value="LabExtensionRequestSearch")
		public ModelAndView LabExtensionRequest(@ModelAttribute(value="lb1")LabRequestBean lb,HttpSession session )
		{   
			ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else{
			System.out.println("inside extend search");
			mv = new ModelAndView();
			List<LabRequestBean> li=null;
			LabExtensionRequestBean ledb = new LabExtensionRequestBean();
			
			try
		       {
				System.out.println("inside extend req search");
		        li = lrs.addLab1(lb);
		       }catch(Exception e)
		       {
		    	   System.out.println(e.getMessage());
		       }
			if(li.isEmpty())
			{
				 mv.setViewName("error");
		    	 mv.addObject("errmsg","Server Error !");
			}
			else
			{
				mv.setViewName("LabExtensionRequest");
				 mv.addObject("search",li);
				 mv.addObject("lb1",ledb);
			}
		}	
		return mv;
			
		}
		@RequestMapping(value="LabExtensionRequestEntry")
		public ModelAndView LabExtensionRequestEntry(@ModelAttribute(value="lb1")LabExtensionRequestBean lb,HttpSession session )
		{   
			ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else{
			mv=new ModelAndView();
			boolean temp=false;
			try
			{
			      temp = lers.requestExtend(lb);
			}
			catch(Exception e)
			{
			e.printStackTrace();
			}
			 if(temp)
		       {
		       mv.setViewName("SuccessLO");
		       mv.addObject("sb",lb);
		       }
			 else
		       {
		    	   mv.setViewName("Error");
		    	   mv.addObject("errmsg","Server Error !");
		       }
			 }
			return mv;
		       
		}
		@Autowired
		LabReleaseRequestService lrrs;
		@RequestMapping(value="LabReleaseRequest")
		public ModelAndView generateReleaseRequestPage(HttpSession session)
		{   ModelAndView mv;
		 if(session==null ||session.isNew())
		 {
			 mv = new ModelAndView("Expired");
		}
		 else{
			
			LabReleaseRequestBean lrrb = new LabReleaseRequestBean();
			 mv = new ModelAndView("LabReleaseRequest","lb1",lrrb);
		 }
			return mv;
		}
		 @RequestMapping(value="LabReleaseRequestSearch")
		public ModelAndView LabReleaseRequest(@ModelAttribute(value="lb1")LabRequestBean lb,HttpSession session)
		{    
	     ModelAndView mv;
		 if(session==null ||session.isNew())
		 {
			 mv = new ModelAndView("Expired");
		}
		 else{
			 System.out.println("inside release search");
			 mv = new ModelAndView();
			 List<LabRequestBean> li=null;
			 LabReleaseRequestBean lrrb = new LabReleaseRequestBean();
			
			try
		       {
				System.out.println("inside release req search");
		        li = lrs.addLab1(lb);
		       }catch(Exception e)
		       {
		    	   System.out.println(e.getMessage());
		       }
			if(li==null)
			{
				 mv.setViewName("LabReleaseRequest");
		    	 mv.addObject("errmsg","Server Error !");
			}
			else
			{
				mv.setViewName("LabReleaseRequest");
				 mv.addObject("search",li);
				 mv.addObject("lb1",lrrb);
			}
		 }
			return mv;
			
		}
		 @RequestMapping(value="LabReleaseRequestEntry")
			public ModelAndView LabReleaseRequestEntry(@ModelAttribute(value="lb1")LabReleaseRequestBean lb,HttpSession session )
			{   
			 ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else{
				mv=new ModelAndView();
				boolean temp=false;
				try
				{
				      temp = lrrs.requestRelease(lb);
				}
				catch(Exception e)
				{
				e.printStackTrace();
				}
				 if(temp)
			       {
			       mv.setViewName("SuccessLO");
			       mv.addObject("sb",lb);
			       }
				 else
			       {
			    	   mv.setViewName("Error");
			    	   mv.addObject("errmsg","Server Error !");
			       }
			 }
				return mv;
			       
			}
		 
		 //for approval of a lab request
		 
		 @RequestMapping(value="RequestUpdate")
			public ModelAndView requestUpdateView(HttpSession session)
			{   
			 ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else{
				LabRequestBean lrb = new LabRequestBean();
			     mv = new ModelAndView();
				List<LabRequestBean> li=null;
				try
			       {
			        li = lrs.LabRequest();
			       }catch(Exception e)
			       {
			    	   System.out.println(e.getMessage());
			       }
				if(li==null)
				{
					 mv.setViewName("RequestUpdateOTH");
			    	 mv.addObject("errmsg","Server Error !");
				}
				else
				{
					mv.setViewName("RequestUpdateOTH");
					 mv.addObject("search",li);
					 mv.addObject("lb",lrb);
				}
			 }
				return mv;
				
			}

			@RequestMapping(value="ApproveRequest")
			public ModelAndView LabRequestApprove(@ModelAttribute(value="lb")LabRequestBean lb,HttpServletRequest request,HttpSession session)
			{   
				ModelAndView mv;
				 if(session==null ||session.isNew())
				 {
					 mv = new ModelAndView("Expired");
				}
				 else{
				LabRequestBean lrb = new LabRequestBean();
				String param=request.getParameter("value");
				mv=new ModelAndView();
				lrb.setBookingId(param);
				System.out.println(lrb.getBookingId());
				List<LabRequestBean> li=null;
				try
			       {
			        li = lrs.LabRequest(lrb);
			       }catch(Exception e)
			       {
			    	   System.out.println(e.getMessage());
			       }
				if(li==null)
				{
					 mv.setViewName("RequestUpdateOTH");
			    	 mv.addObject("errmsg","Server Error !");
				}
				else
				{
					mv.setViewName("ApproveRequest");
					 mv.addObject("search",li);
					 mv.addObject("lb",lrb);
				}
				 }
				return mv;
				
			      
			}
			@RequestMapping(value="LabRequestEntryApprove")
			public ModelAndView LabRequestEntryApprove(@ModelAttribute(value="ldb")LabRequestBean lb,HttpSession session )
			{   
				ModelAndView mv;
				 if(session==null ||session.isNew())
				 {
					 mv = new ModelAndView("Expired");
				}
				 else{
				mv=new ModelAndView();
				int temp=0;
				try
				{
				      temp = lrs.updateLab(lb);
				}
				catch(Exception e)
				{
				e.printStackTrace();
				}
				 if(temp!=0)
			       {
					   mv.setViewName("SuccessRequest");
			       mv.addObject("sdata",lb);
			       }
				 else
			       {
			    	   mv.setViewName("Error");
			    	   mv.addObject("errmsg","Server Error !");
			       }
				 }
				return mv;
			       
			}
			@RequestMapping(value="ExtensionRequestUpdate")
			public ModelAndView requestExtendUpdateView(HttpSession session)
			{   
				ModelAndView mv;
				 if(session==null ||session.isNew())
				 {
					 mv = new ModelAndView("Expired");
				}
				 else{
				LabExtensionRequestBean lerb = new LabExtensionRequestBean();
				mv = new ModelAndView();
				List<LabExtensionRequestBean> li=null;
				try
			       {
			        li = lers.LabRequest();
			       }catch(Exception e)
			       {
			    	   System.out.println(e.getMessage());
			       }
				if(li==null)
				{
					 mv.setViewName("ExtensionRequestUpdateOTH");
			    	 mv.addObject("errmsg","Server Error !");
				}
				else
				{
					mv.setViewName("ExtensionRequestUpdateOTH");
					 mv.addObject("search",li);
					 mv.addObject("lb",lerb);
				}
			}
				return mv;
				
			}

			@RequestMapping(value="ApproveExtensionRequest")
			public ModelAndView LabExtensionRequestApprove(@ModelAttribute(value="lb")LabExtensionRequestBean lb,HttpServletRequest request,HttpSession session)
			{
				ModelAndView mv;
				 if(session==null ||session.isNew())
				 {
					 mv = new ModelAndView("Expired");
				}
				 else{
				LabExtensionRequestBean lrb = new LabExtensionRequestBean();
				String param=request.getParameter("value");
				mv=new ModelAndView();
				lrb.setBookingId(param);
				System.out.println(lrb.getBookingId());
				List<LabExtensionRequestBean> li=null;
				try
			       {
			        li = lers.LabRequest(lrb);
			       }catch(Exception e)
			       {
			    	   System.out.println(e.getMessage());
			       }
				if(li==null)
				{
					 mv.setViewName("ApproveExtensionRequest");
			    	 mv.addObject("errmsg","Server Error !");
				}
				else
				{
					mv.setViewName("ApproveExtensionRequest");
					 mv.addObject("search",li);
					 mv.addObject("lb",lrb);
				}
			}
				return mv;
				
			      
			}
			@RequestMapping(value="LabExtensionRequestEntryApprove")
			public ModelAndView LabExtensionRequestEntryApprove(@ModelAttribute(value="ldb")LabExtensionRequestBean lb,HttpSession session )
			{   
				ModelAndView mv;
				 if(session==null ||session.isNew())
				 {
					 mv = new ModelAndView("Expired");
				}
				 else{
				mv=new ModelAndView();
				int temp=0;
				try
				{
				      temp = lers.updateLab(lb);
				}
				catch(Exception e)
				{
				e.printStackTrace();
				}
				 if(temp!=0)
			       {
					   mv.setViewName("SuccessRequest");
			       mv.addObject("sdata",lb);
			       }
				 else
			       {
			    	   mv.setViewName("Error");
			    	   mv.addObject("errmsg","Server Error !");
			       }
				 }
				return mv;
			       
			}
			//for update release request
			
			@RequestMapping(value="ReleaseRequestUpdate")
			public ModelAndView requestReleaseUpdateView(HttpSession session)
			{   
				ModelAndView mv;
				 if(session==null ||session.isNew())
				 {
					 mv = new ModelAndView("Expired");
				}
				 else{
				LabReleaseRequestBean lrb = new LabReleaseRequestBean();
				mv = new ModelAndView();
				List<LabReleaseRequestBean> li=null;
				try
			       {
			        li = lrrs.LabRequest();
			       }catch(Exception e)
			       {
			    	   System.out.println(e.getMessage());
			       }
				if(li==null)
				{
					 mv.setViewName("ReleaseRequestUpdateOTH");
			    	 mv.addObject("errmsg","Server Error !");
				}
				else
				{
					mv.setViewName("ReleaseRequestUpdateOTH");
					 mv.addObject("search",li);
					 mv.addObject("lb",lrb);
				}
			}
				return mv;
				
			}
			@RequestMapping(value="ApproveReleaseRequest")
			public ModelAndView LabReleaseRequestApprove(@ModelAttribute(value="lb")LabReleaseRequestBean lb,HttpServletRequest request,HttpSession session)
			{   
				ModelAndView mv;
				 if(session==null ||session.isNew())
				 {
					 mv = new ModelAndView("Expired");
				}
				 else{
				LabReleaseRequestBean lrb = new LabReleaseRequestBean();
				String param=request.getParameter("value");
				mv=new ModelAndView();
				lrb.setBookingId(param);
				System.out.println(lrb.getBookingId());
				List<LabReleaseRequestBean> li=null;
				try
			       {
			        li = lrrs.LabRequest(lrb);
			       }catch(Exception e)
			       {
			    	   System.out.println(e.getMessage());
			       }
				if(li.isEmpty())
				{
					 mv.setViewName("ReleaseRequestUpdateOTH");
			    	 mv.addObject("errmsg","Server Error !");
				}
				else
				{
					mv.setViewName("ApproveReleaseRequest");
					 mv.addObject("search",li);
					 mv.addObject("lb",lrb);
				}
			}
				return mv;
			}
			@RequestMapping(value="LabReleaseRequestEntryApprove")
			public ModelAndView LabReleaseRequestEntryApprove(@ModelAttribute(value="ldb")LabReleaseRequestBean lb,HttpSession session)
			{   
				ModelAndView mv;
				 if(session==null ||session.isNew())
				 {
					 mv = new ModelAndView("Expired");
				}
				 else{
				mv=new ModelAndView();
				int temp=0;
				try
				{
				      temp = lrrs.updateLab(lb);
				}
				catch(Exception e)
				{
				e.printStackTrace();
				}
				 if(temp!=0)
			       {
			       mv.setViewName("SuccessRequest");
			       mv.addObject("sdata",lb);
			       }
				 else
			       {
			    	   mv.setViewName("Error");
			    	   mv.addObject("errmsg","Server Error !");
			       }
				 }
				return mv;
			       
			}
			@RequestMapping(value="LabStatus")
			public ModelAndView generatestatusPage(HttpSession session)
			{   ModelAndView mv;
			 if(session==null ||session.isNew())
			 {
				 mv = new ModelAndView("Expired");
			}
			 else{
				mv = new ModelAndView("LabStatus");
			 }
				return mv;
			}
			@RequestMapping(value="Request")
			public ModelAndView requestView(HttpSession session)
			{   
				ModelAndView mv;
				 if(session==null ||session.isNew())
				 {
					 mv = new ModelAndView("Expired");
				}
				 else{
				mv = new ModelAndView();
				List<LabRequestBean> li=null;
				try
			       {
			        li = lrs.LabRequest();
			       }catch(Exception e)
			       {
			    	   System.out.println(e.getMessage());
			       }
				if(li.isEmpty())
				{
					 mv.setViewName("error");
			    	 mv.addObject("errmsg","Server Error !");
				}
				else
				{
					mv.setViewName("Request");
					 mv.addObject("search",li);
					
				}
			}
				return mv;
				
			}
			@RequestMapping(value="Extension")
			public ModelAndView extensionView(HttpSession session)
			{   
				 ModelAndView mv;
				 if(session==null ||session.isNew())
				 {
					 mv = new ModelAndView("Expired");
				}
				 else{
				mv = new ModelAndView();
				List<LabExtensionRequestBean> li=null;
				try
			       {
			        li = lers.LabRequest();
			       }catch(Exception e)
			       {
			    	   System.out.println(e.getMessage());
			       }
				if(li.isEmpty())
				{
					 mv.setViewName("error");
			    	 mv.addObject("errmsg","Server Error !");
				}
				else
				{
					mv.setViewName("Extension");
					 mv.addObject("search",li);
					
				}
			}
				return mv;
				
			}
			@RequestMapping(value="Release")
			public ModelAndView releaseView(HttpSession session)
			{   
				ModelAndView mv;
				 if(session==null ||session.isNew())
				 {
					 mv = new ModelAndView("Expired");
				}
				 else{
				mv = new ModelAndView();
				List<LabReleaseRequestBean> li=null;
				try
			       {
			        li = lrrs.LabRequest();
			       }catch(Exception e)
			       {
			    	   System.out.println(e.getMessage());
			       }
				if(li.isEmpty())
				{
					 mv.setViewName("error");
			    	 mv.addObject("errmsg","Server Error !");
				}
				else
				{
					mv.setViewName("Release");
					 mv.addObject("search",li);
					
				}
			}
				return mv;
				
			}
		}
