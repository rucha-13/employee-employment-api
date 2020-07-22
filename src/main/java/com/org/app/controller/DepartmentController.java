package com.org.app.controller;

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

import com.org.app.model.Department;
import com.org.app.services.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService service;
	
	@RequestMapping(value = "/department" , consumes = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	public ResponseEntity<Department> insertDepartmentDetail(@RequestBody Department department){
		Department dpt = service.saveDepartmentDetails(department);
		return ResponseEntity.accepted().body(dpt);
	}
	
	@RequestMapping("/departments")
	public ResponseEntity<List<Department>> getAllDepartments(){
		List<Department> departmentList = service.getAllDepartmentDetails();
		return ResponseEntity.status(HttpStatus.FOUND).body(departmentList);
	}
	
	@RequestMapping(value = "/department/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public ResponseEntity<Department> changeOfficeForDepartment(@RequestBody Department department,@PathVariable("id") Integer deptId){
		Department updatedDept = service.updateDeptOffice(department, deptId);
		return ResponseEntity.status(HttpStatus.CREATED).body(updatedDept);
	}
	
	@RequestMapping(value = "/department/name/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public ResponseEntity<Department> updateDepartmentName(@RequestBody Department department,@PathVariable("id") Integer deptId){
		Department updatedDept = service.updateDepartmentName(department, deptId);
		return ResponseEntity.status(HttpStatus.CREATED).body(updatedDept);
	}
	
	@RequestMapping(value = "/departments", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAllDepartmentDetails() {
		service.deleteAllDepartmentDetails();
		return ResponseEntity.status(HttpStatus.CREATED).body("Deleted All details of department");
	}
	
	@RequestMapping(value = "/department/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteDepartmentDetailById(@PathVariable("id") Integer deptId) {
		service.deleteDepartmentById(deptId);
		return ResponseEntity.status(HttpStatus.CREATED).body("Deleted department details for id " + deptId);
	}
	
	@RequestMapping("/department/{id}")
	public ResponseEntity<Department> getDepartmentDetailsById(@PathVariable("id") Integer deptId){
		Department department  = service.getDepartmentDetailsByDeptId(deptId);
		return ResponseEntity.status(HttpStatus.FOUND).body(department);
	}
}
