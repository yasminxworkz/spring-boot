package com.xworkz.UserService.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xworkz.UserService.dto.RatingDTO;
import com.xworkz.UserService.dto.ResponseDTO;
import com.xworkz.UserService.dto.UserDTO;
import com.xworkz.UserService.entity.UserEntity;
import com.xworkz.UserService.repository.UserRepo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImp implements UserService {

	
	private UserRepo repo;
	
	private RestTemplate restTemplate;

	@Override
	public UserEntity saveUser(UserEntity user) {
		log.info("running save method in userService.........");
		return repo.save(user);
	}

	@Override
	public ResponseDTO getUserById(Long userId) {
		log.info("running userById in Userservice ..........");
		
		ResponseDTO response=new ResponseDTO();
		UserEntity user=repo.findById(userId).get();
		UserDTO dto=mapToUser(user);
		ResponseEntity<RatingDTO> responseEntity=restTemplate.getForEntity("http://localhost:8082/rating/"+user.getRatingId(), RatingDTO.class);
		RatingDTO ratingDTO=responseEntity.getBody();
		
		log.info(""+responseEntity.getStatusCode());
		
		response.setRatingDTO(ratingDTO);
		response.setUser(dto);
		
		return response;
	}
	
	private UserDTO mapToUser(UserEntity entity) {
		UserDTO dto=new UserDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		return dto;
	}

	@Override
	public UserEntity findById(Long userId) {
		log.info("running findById in userService.........");
		return repo.findById(userId).get();
	}
	
	
	

	

}
