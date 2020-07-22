package com.org.app.services;

import java.sql.Date;
import java.util.List;

import com.org.app.model.Employee;


public interface EmployeeService {
	public List<Employee>findAllEmployee();
	public Employee saveEmployeeRecord(Employee emp);
	public Employee fetchEmployeeByEmpID(Integer empID);
	public void deleteAllEmployees();
	public void deleteByEmpId(Integer empId);
	public List<Employee> fetchEmployeesByDOJAndSalary(Date doj,Double salary);
	public Employee updateEmployeeDetails(Employee emp,Integer empId);
}
