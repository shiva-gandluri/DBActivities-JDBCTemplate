package com.example.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
	
	Integer id;
	Integer age;
	String First;
	String Last;

	@PostMapping (value = "/Record-Data")
	public void setValues(@RequestBody UserDetails input)
	 {
		 this.id = input.getId();
		 this.First = input.getFirstName();
		 this.Last = input.getLastName();
		 this.age = input.getAge();
		 
		 UserJDBCTemplate user = new UserJDBCTemplate();
		 //user.setDataSource(Datasource ds);
		 user.update(this.id, this.First, this.Last, this.age);
		 System.out.println("Update Successful");
		 user.getUserDetails();

	 
	 }	
}
