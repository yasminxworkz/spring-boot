package com.xworkz.teacher.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xworkz.teacher.dto.DepartmentDTO;
import com.xworkz.teacher.dto.ResponseDTO;
import com.xworkz.teacher.dto.TeacherDTO;
import com.xworkz.teacher.entity.Teacher;
import com.xworkz.teacher.repository.TeacherRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@AllArgsConstructor
@Slf4j
public class TeacherServiceImp  implements TeacherService{

	
	TeacherRepository teacherRepo;
	
	RestTemplate restTemplate;
	
	
	@Override
	public Teacher saveTeacher(Teacher teacher) {
		log.info("running save in teacherService....................... ");
		return teacherRepo.save(teacher);
	}

	@Override
	public ResponseDTO getTeacher(Long userId) {
		log.info("running getTeacher in teacherService....................... ");
        ResponseDTO response=new ResponseDTO();
        Teacher teacher=teacherRepo.findById(userId).get();
        TeacherDTO teacherDTO=mapToUser(teacher);
        
        ResponseEntity<DepartmentDTO> responseEntity=restTemplate.getForEntity("http://localhost:6012/api/departments/"+teacher.getDepartmentId(), DepartmentDTO.class);
        DepartmentDTO departmentDto = responseEntity.getBody();

        log.info(""+responseEntity.getStatusCode());

   
        response.setDepartmentDTO(departmentDto);
        response.setTeacherDTO(teacherDTO);
		return response;
	}
	
	private TeacherDTO mapToUser(Teacher teacher){
		TeacherDTO teacherDTO = new TeacherDTO();
		teacherDTO.setId(teacher.getId());
		teacherDTO.setFirstName(teacher.getFirstName());
		teacherDTO.setLastName(teacher.getLastName());
		teacherDTO.setEmail(teacher.getEmail());
        return teacherDTO;
    }

	@Override
	public ResponseDTO getByEmail(String email) {
		log.info("running getTeacher in teacherService....................... ");
        ResponseDTO response=new ResponseDTO();
        Teacher teacher=teacherRepo.findByEmail(email);
        TeacherDTO teacherDTO=mapToUser(teacher);
        
        ResponseEntity<DepartmentDTO> responseEntity=restTemplate.getForEntity("http://localhost:6012/api/departments/"+teacher.getDepartmentId(), DepartmentDTO.class);
        DepartmentDTO departmentDto = responseEntity.getBody();

        
        log.info(""+responseEntity.getStatusCode());

   
        response.setDepartmentDTO(departmentDto);
        response.setTeacherDTO(teacherDTO);
		return response;
	}

	@Override
	public List<Teacher> findAll() {
		List<Teacher> list=teacherRepo.findAll();
		
		return list;
	}

	
	
	

}
