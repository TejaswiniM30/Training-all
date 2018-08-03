package com.training.interfaces;

import java.util.List;
import com.training.entity.*;

import javax.sql.DataSource;

import com.training.entity.Employee;

public interface IEmployeeDAO {
	//CURD operations
	
	
	public Employee getEmployee(int empId);
	
	public List<Employee> getAllEmps();
	
	public void insertEmployee(Employee employee);
	
	public void deleteEmployee(int empId);
	
	public void updateEmployee(int empId, double empNewSalary);
	
	//datasource shall be injected from .xml file to the implementation class and that is mandatory
	//the variable name dataSource
	
	public void setDataSource(DataSource dataSource);
}
