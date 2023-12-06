package com.xworkz.UserService.service;

import com.xworkz.UserService.dto.ResponseDTO;
import com.xworkz.UserService.entity.UserEntity;

public interface UserService {
	
	UserEntity saveUser(UserEntity user);
	
	ResponseDTO getUserById(Long userId);

	public UserEntity findById(Long userId);
}
