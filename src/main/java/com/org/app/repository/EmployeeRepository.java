package com.org.app.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.app.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	@Query("select emp from Employee emp where emp.dateOfJoining > :doj and emp.salary > :salary ")
	public List<Employee> findAllByDateOfJoiningAndSalary(@Param("doj") Date doj,@Param("salary") Double salary);
}
