package com.xworkz.department.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentDTO {
	
	private Long id;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
