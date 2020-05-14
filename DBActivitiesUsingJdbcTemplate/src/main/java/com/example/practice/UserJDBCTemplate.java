package com.example.practice;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBCTemplate implements UserDAO{
	   private DataSource dataSource;
	   private JdbcTemplate jdbcTemplate;
	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
	      this.dataSource = dataSource;
	      this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}
	@Override
	public void update(Integer id, String First, String Last, Integer age) {
		// TODO Auto-generated method stub
		String Update_EMPLOYEE_SQL="INSERT INTO Registration " +
				"VALUES ("+id+", '"+First+"', '"+Last+"', "+age+")";
		jdbcTemplate.update(Update_EMPLOYEE_SQL, id, First, Last, age);
		return ;
		
	}
	@Override
	public UserDetails getUserDetails() {
		// TODO Auto-generated method stub
	      String SQL = "select * from employee";
	      UserDetails employee = jdbcTemplate.queryForObject(
	         SQL, new UserDetailsRowMapper());
	      return employee;
	}

}
