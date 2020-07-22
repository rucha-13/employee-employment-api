package com.org.app.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.app.model.Employee;
import com.org.app.model.Winner;
import com.org.app.services.EmployeeService;
import com.org.app.services.WinnerService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private WinnerService winnerService;
	
	@RequestMapping(value = "/employee",consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Employee> saveEmployeeDetails(@RequestBody Employee employee ){
		Employee emp = service.saveEmployeeRecord(employee);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(emp);
	}
	
	@RequestMapping(value = "/employees")
	public ResponseEntity<List<Employee>> getAllEmployeeRecords(){
		List<Employee> employeeList = service.findAllEmployee();
		return ResponseEntity.status(HttpStatus.FOUND).body(employeeList);
	}

	@RequestMapping(value = "/employee/{id}")
	public ResponseEntity<Employee> getEmployeeRecordById(@PathVariable("id")Integer id){
		Employee emp = service.fetchEmployeeByEmpID(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(emp);
	}
	
	@RequestMapping(value = "/employees",method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAllEmployees(){
		service.deleteAllEmployees();
		return ResponseEntity.status(HttpStatus.FOUND).body("delete all employees");
	}
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Integer id){
		service.deleteByEmpId(id);
		return ResponseEntity.status(HttpStatus.FOUND).body("delete all employee" + id);
	}
	
	@RequestMapping(value = "/employee/{date}/{salary}")
	public ResponseEntity<List<Employee>> fetchEmployeesByDOJAndSalary(@PathVariable("date") Date doj,@PathVariable("salary") Double salary){
		List <Employee>employeesRecord = service.fetchEmployeesByDOJAndSalary(doj, salary);
		return ResponseEntity.status(HttpStatus.FOUND).body(employeesRecord);
	}
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployeeDetails(@RequestBody Employee emp,@PathVariable("id") Integer id){
		Employee employee = service.updateEmployeeDetails(emp, id);
		return ResponseEntity.status(HttpStatus.FOUND).body(employee);
	}
	
	@RequestMapping(value="/winner/{month}/{year}")
	public ResponseEntity<Winner> findWinnerMonthly(@PathVariable("month") int month,@PathVariable("year") int year){
		Winner winner = winnerService.findWinner(month, year);
		return ResponseEntity.status(HttpStatus.FOUND).body(winner);
	} 
	
	@RequestMapping(value="/winners")
	public ResponseEntity<List<Winner>> findAllWinners(){
		List <Winner>winnerList = winnerService.findAll();
		return ResponseEntity.status(HttpStatus.FOUND).body(winnerList);
	} 
}
