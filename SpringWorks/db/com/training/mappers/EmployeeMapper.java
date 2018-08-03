package com.training.mappers;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.training.entity.Employee;

public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEmpId(rs.getInt("empid"));
		employee.setEmpName(rs.getString("empname"));
		employee.setEmpSal(rs.getDouble("empsal"));
		return employee;
	}
	

}
