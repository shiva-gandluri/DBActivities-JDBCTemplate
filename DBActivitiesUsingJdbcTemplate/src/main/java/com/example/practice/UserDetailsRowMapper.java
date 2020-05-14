package com.example.practice;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

public class UserDetailsRowMapper implements RowMapper<UserDetails> {

	@Override
	public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDetails employee = new UserDetails();
		employee.setId(rs.getInt("id"));
		employee.setFirstName(rs.getString("First Name"));
		employee.setLastName(rs.getString("Last Name"));
		employee.setAge(rs.getInt("Age"));
		return employee;
		// TODO Auto-generated method stub
		
	}

}
