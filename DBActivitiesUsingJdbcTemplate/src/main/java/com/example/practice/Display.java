package com.example.practice;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Display {
	String rec;
	Integer id;
	Integer age;
	String First;
	String Last;
	@GetMapping (value = "B")
	public String setValues()
	 {
		
		 try{
			System.out.println("Registering a driver...");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","0000");
			//here sonoo is the database name, root is the username and root is the password
			System.out.println("creating Statement object..");
			Statement stmt=con.createStatement();

			/*ResultSet rs=stmt.executeQuery("select * from sys_config");

			while(rs.next())
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

			con.close();

			*/
			System.out.println("using database..");
			stmt.executeUpdate("use employee");
			//System.out.println("created new database..");
			//System.out.println("Created table in given database...");
			//stmt.executeUpdate("CREATE TABLE REGISTRATION (id INTEGER not NULL,  first VARCHAR(255), last VARCHAR(255),  age INTEGER,  PRIMARY KEY ( id ))");
			/*String sql = "INSERT INTO Registration " +
	                "VALUES (100, 'shiva', 'G', 23)";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO Registration " +
	                "VALUES (102, 'sai', 'G', 21)";
			stmt.executeUpdate(sql);
			System.out.println("Inserted records into the table...");
			ResultSet rs = stmt.executeQuery("select * from registration");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				
			}*/

			ResultSet rs1 = stmt.executeQuery("select * from registration");
			while(rs1.next()) {
		         int id  = rs1.getInt("id");
		         int age = rs1.getInt("age");
		         String first = rs1.getString("first");
		         String last = rs1.getString("last");
		         
		         rec += id+" "+first+" "+last+" "+age+" \n";
		         
				//System.out.println(rs1.getInt(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4));

			}
			return (rec);
			}catch(Exception e){ System.out.println(e);}
		 return null;
		 
				
		
			
			

	 
	 }	
}
