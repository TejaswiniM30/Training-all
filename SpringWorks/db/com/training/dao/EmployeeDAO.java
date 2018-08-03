package com.training.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.training.entity.Employee;
import com.training.interfaces.IEmployeeDAO;
import com.training.mappers.EmployeeMapper;

public class EmployeeDAO implements IEmployeeDAO{
	
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	

	@Override
	public Employee getEmployee(int empId) {
		String sql = "select empid, empname, empsal from Employee where empid=?";
	//	Employee employee = jdbcTemplateObject.queryForObject(sql, new Object[] {empId}, new BeanPropertyRowMapper<Employee>(Employee.class));
		Employee employee = jdbcTemplateObject.queryForObject(sql, new Object[] {empId}, new EmployeeMapper());
				
		return employee;
	}

	@Override
	public List<Employee> getAllEmps() {
		String sql = "select empid, empname, empsal from Employee";
		List<Employee> list = new ArrayList<Employee>();
		List<Map<String, Object>> rows = jdbcTemplateObject.queryForList(sql);
		
		for(Map row: rows) {
			Employee employee = new Employee();
			employee.setEmpId(Integer.parseInt(row.get("empid").toString()));
			employee.setEmpName(row.get("empname").toString());
			employee.setEmpSal(Double.parseDouble(row.get("empsal").toString()));
			list.add(employee);
		}
		return list;
	}

	@Override
	public void insertEmployee(Employee employee) {
		String sql = "insert into Employee(empid, empname, empsal)"+"values(?,?,?)";
		
		jdbcTemplateObject.update(sql,employee.getEmpId(),employee.getEmpName(),employee.getEmpSal());
		
		System.out.println("Record created "+employee);
		return ;
	}

	@Override
	public void deleteEmployee(int empId) {
		
	}

	@Override
	public void updateEmployee(int empId, double empNewSalary) {
		
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		this.jdbcTemplateObject= new JdbcTemplate(dataSource);
	}
	
}
