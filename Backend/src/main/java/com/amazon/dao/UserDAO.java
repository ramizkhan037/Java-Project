package com.amazon.dao;

import com.amazon.model.UserDetail;

public interface UserDAO 
{
  public boolean registerUser(UserDetail userDetail);
  public boolean updateUser(UserDetail userDetail);
  public UserDetail getUser(String username);
}                                   
