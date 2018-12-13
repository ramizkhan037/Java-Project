package com.amazon.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserDetail 
{
  @Id
  String username;
  String password;
  boolean enabled;
  String role;
  
  
  String customername;
  String mobileNo;
  String emailId;
  String address;
  
   public String getUsername() 
    {
	  return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public boolean isEnabled() 
	{
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getRole() 
	{
		return role;
	}
	public void setRole(String role) 
	{
		this.role = role;
	}
	public String getCustomername() 
	{
		return customername;
	}
	public void setCustomername(String customername) 
	{
		this.customername = customername;
	}
	public String getMobileNo() 
	{
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) 
	{
		this.mobileNo = mobileNo;
	}
	public String getEmailId() 
	{
		return emailId;
	}
	public void setEmailId(String emailId) 
	{
		this.emailId = emailId;
	}
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

 }
