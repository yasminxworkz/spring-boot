package com.xworkz.department.service;

import com.xworkz.department.entity.Department;


public interface DepartmentService {
	
	Department saveDepartment(Department department);

    Department getDepartmentById(Long departmentId);

}
