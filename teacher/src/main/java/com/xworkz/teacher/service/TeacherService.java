package com.xworkz.teacher.service;

import java.util.List;

import com.xworkz.teacher.dto.ResponseDTO;
import com.xworkz.teacher.entity.Teacher;

public interface TeacherService {
	
	Teacher saveTeacher(Teacher teacher);
	
	ResponseDTO getTeacher(Long userId);
	
	ResponseDTO getByEmail(String email);
	
	public List<Teacher> findAll();
	
	

}
