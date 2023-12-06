package com.xworkz.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xworkz.UserService.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long>{
	
	

}
