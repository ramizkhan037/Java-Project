package com.amazon.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.amazon.dao.UserDAO;
import com.amazon.model.UserDetail;

public class UserDAOTest 
{
	static UserDAO userDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.amazon");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
    @Ignore
	@Test
	public void registerUserTest()
	{
	  UserDetail userDetail=new UserDetail();
	  userDetail.setUsername("ramiz1");
	  userDetail.setPassword("r123");
	  userDetail.setCustomername("Ramiz Khan");
	  userDetail.setEnabled(true);
	  userDetail.setAddress("Pune");
	  userDetail.setMobileNo("8806069879");
	  userDetail.setEmailId("ramiz@gmail.com");
	  userDetail.setRole("Role_User");
	  
	  assertTrue("Probem in Adding the User",userDAO.registerUser(userDetail));	  
	}
    @Ignore
    @Test
	 public void updateUserTest()
	 {
    	UserDetail userDetail=userDAO.getUser("ramiz");
    	userDetail.setAddress("Mumbai");
    	userDetail.setMobileNo("9765058762");
  	    
    	assertTrue("Probem in Updating the User",userDAO.updateUser(userDetail));	  

    	
	 }
}
