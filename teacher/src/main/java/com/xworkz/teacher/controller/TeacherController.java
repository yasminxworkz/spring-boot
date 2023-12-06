package com.xworkz.teacher.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.teacher.dto.ResponseDTO;
import com.xworkz.teacher.entity.Teacher;
import com.xworkz.teacher.service.TeacherService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
@Slf4j
public class TeacherController {
	
	private TeacherService teacherService;
	
	@PostMapping
    public ResponseEntity<Teacher> saveUser(@RequestBody Teacher user){
		log.info("running save method in TeacherController........................");
        Teacher savedUser = teacherService.saveTeacher(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable("id") Long userId){
		log.info("running getUser method in TeacherController........................");

        ResponseDTO responseDto = teacherService.getTeacher(userId);
        
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/byEmail/{email}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable String email){
		log.info("running getUser method in TeacherController........................");

        ResponseDTO responseDto = teacherService.getByEmail(email);
        
        return ResponseEntity.ok(responseDto);
    }
    
    @GetMapping("/findAll")
    public List<Teacher> findAll(){
		log.info("running findAll method in TeacherController........................");

    	List<Teacher> list=teacherService.findAll();
    	return list;
    }
}
