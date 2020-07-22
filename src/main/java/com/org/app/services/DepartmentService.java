package com.org.app.services;

import java.util.List;

import com.org.app.model.Department;
import com.org.app.model.Office;

public interface DepartmentService {

	public List<Department> getAllDepartmentDetails();
	public Department getDepartmentDetailsByDeptId(Integer dId);
	public void deleteAllDepartmentDetails();
	public void deleteDepartmentById(Integer id);
	public Department updateDepartmentName(Department department,Integer deptId);
	public Department saveDepartmentDetails(Department dept);
	public Department updateDeptOffice(Department department,Integer deptId);
	
}
