package com.xworkz.department.service;

import org.springframework.stereotype.Service;

import com.xworkz.department.entity.Department;
import com.xworkz.department.repository.DepartmentRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class DepartmentServiceImp implements DepartmentService{

	
	private DepartmentRepository repo;
	
	
	
	@Override
	public Department saveDepartment(Department department) {
		log.info("running save method in service.............");
		return repo.save(department);
	}

	@Override
	public Department getDepartmentById(Long departmentId) {
		log.info("running getDepartmentById method in service.............");
		return repo.findById(departmentId).get();
	}

	

}
