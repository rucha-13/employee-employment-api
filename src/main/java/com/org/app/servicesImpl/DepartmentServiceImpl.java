package com.org.app.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.app.model.Department;
import com.org.app.repository.DepartmentRepository;
import com.org.app.services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository repo;
	@Override
	public List<Department> getAllDepartmentDetails() {
		List<Department> departmentList = new ArrayList<Department>();
		repo.findAll().forEach(departmentList::add);
		return departmentList;
	}

	@Override
	public Department getDepartmentDetailsByDeptId(Integer dId) {
		return repo.findById(dId).get();
	}

	@Override
	public void deleteAllDepartmentDetails() {
		repo.deleteAll();
	}

	@Override
	public Department updateDepartmentName(Department department, Integer deptId) {
		Department dept = this.getDepartmentDetailsByDeptId(deptId);
		dept.setName(department.getName());
		return repo.save(department);
	}

	@Override
	public Department saveDepartmentDetails(Department dept) {
		return repo.save(dept);
	}

	@Override
	public Department updateDeptOffice(Department deprt, Integer deptId) {
		Department department = this.getDepartmentDetailsByDeptId(deptId);
		department.setOffice(deprt.getOffice());
		return repo.save(department);
	}

	@Override
	public void deleteDepartmentById(Integer id) {
		repo.deleteById(id);
		
	}

}
