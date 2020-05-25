package com.example.practice;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBCTemplate implements UserDAO{
	   //private DataSource dataSource;
	   //private JdbcTemplate jdbcTemplate;
	   @Qualifier("mysqlService")
		@Autowired
		JdbcTemplate mysqlService;

	@Override
	public void update(Integer id, String First, String Last, Integer age) {
		// TODO Auto-generated method stub
		String Update_EMPLOYEE_SQL="INSERT INTO Registration " +
				"VALUES ("+id+", '"+First+"', '"+Last+"', "+age+")";
		mysqlService.update(Update_EMPLOYEE_SQL, id, First, Last, age);
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
