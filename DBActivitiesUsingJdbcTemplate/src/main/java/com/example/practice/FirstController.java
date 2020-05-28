package com.example.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
	@Autowired
	UserJDBCTemplate mysqlService;
	
	Integer id;
	Integer age;
	String first;
	String last;



	@PostMapping (value = "/Record-Data")
	public void setValues(@RequestBody UserDetails input)
	 {
		 this.id = input.getId();
		 this.first = input.getFirstName();
		 this.last = input.getLastName();
		 this.age = input.getAge();
		 
		
		 //user.setDataSource(Datasource ds);
		 mysqlService.updateInfo(id, first, last, age);
		 System.out.println("Update Successful");
		 mysqlService.getUserDetails();

	 
	 }	
}
