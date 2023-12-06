package com.xworkz.UserService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.UserService.dto.ResponseDTO;
import com.xworkz.UserService.entity.UserEntity;
import com.xworkz.UserService.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/user")
@Slf4j
@AllArgsConstructor
public class UserController {
	
	
	UserService service;
	
	@PostMapping
	public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user){
		log.info("running save method in UserController..........................");
		UserEntity entity=service.saveUser(user);
		return new ResponseEntity<>(entity,HttpStatus.CREATED);
	}
	
	@GetMapping("/rating/{userId}")
	public ResponseEntity<ResponseDTO> getElementById(@PathVariable Long userId){
		log.info("running getElementById method in UserController..........................");
		ResponseDTO responseDTO=service.getUserById(userId);
		return  ResponseEntity.ok(responseDTO);
	}
	
	@GetMapping("{userId}")
	public ResponseEntity<UserEntity> findById(@PathVariable Long userId){
		log.info("running findById method in UserController..........................");
		UserEntity ent=service.findById(userId);
		return ResponseEntity.ok(ent);
	}
}
