package com.org.app.servicesImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.app.model.Employee;
import com.org.app.repository.EmployeeRepository;
import com.org.app.services.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public List<Employee>findAllEmployee(){
		List<Employee> employeeRecords = new ArrayList<Employee>();
		repo.findAll().forEach(employeeRecords::add);
		return employeeRecords;												
	}

	@Override
	public Employee saveEmployeeRecord(Employee emp) {
		return repo.save(emp);
	}

	@Override
	public Employee fetchEmployeeByEmpID(Integer empID) {
		return repo.findById(empID).get();
	}

	@Override
	public void deleteAllEmployees() {
		repo.deleteAll();
		
	}

	@Override
	public void deleteByEmpId(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<Employee> fetchEmployeesByDOJAndSalary(Date doj, Double salary) {
		return repo.findAllByDateOfJoiningAndSalary(doj, salary);
	}

	@Override
	public Employee updateEmployeeDetails(Employee emp,Integer empId) {
		Employee oldEmployee = this.fetchEmployeeByEmpID(empId);
		if(emp.getDepartment()!=null)
			oldEmployee.setDepartment(emp.getDepartment());
		if(emp.getEmail()!=null)
			 oldEmployee.setEmail(emp.getEmail());
		if(emp.getMobileNo()!=null)
			oldEmployee.setMobileNo(emp.getMobileNo());
		if(emp.getOffice()!=null)
			oldEmployee.setOffice(emp.getOffice());
		if(emp.getSalary()!=null)
			oldEmployee.setSalary(emp.getSalary());
		return repo.save(oldEmployee);
	}
	
}
