package com.xworkz.department.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDTO {
	
	private DepartmentDTO departmentDTO;
	private TeacherDTO teacherDTO;

}
