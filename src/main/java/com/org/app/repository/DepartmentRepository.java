package com.org.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.app.model.Department;
@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
