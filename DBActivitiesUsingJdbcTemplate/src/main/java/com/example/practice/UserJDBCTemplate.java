package com.example.practice;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class UserJDBCTemplate implements UserDAO{
	   //private DataSource dataSource;
	   //private JdbcTemplate jdbcTemplate;
	   @Qualifier("mysqlService")
		@Autowired
		JdbcTemplate mysqlService;

	/*@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
	      this.dataSource = dataSource;
	      this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}*/
	@Override
	public void updateInfo(Integer id, String First, String Last, Integer age) {
		// TODO Auto-generated method stub
		String Update_EMPLOYEE_SQL="INSERT INTO Registration VALUES (?, ?, ?, ?)";
		mysqlService.update(Update_EMPLOYEE_SQL, id, First, Last, age);
		// define query arguments
		//Object[] params = {id, First, Last, age};
		// define SQL types of the arguments
		//int[] types = {Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.INTEGER};
		//int rows = mysqlService.update(Update_EMPLOYEE_SQL, id, First, Last, age);
		//System.out.println(rows + " row(s) updated.");
		return ;
		
	}
	@Override
	public UserDetails getUserDetails() {
		// TODO Auto-generated method stub
	      String SQL = "select * from employee";
	      UserDetails employee = mysqlService.queryForObject(
	         SQL, new UserDetailsRowMapper());
	      return employee;
	}
	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		
	}

}
