package com.example.practice;

import javax.sql.DataSource;

public interface UserDAO {

   public void setDataSource(DataSource ds);

   public void update(Integer id, String First, String Last, Integer age);
   
   public UserDetails getUserDetails();
}