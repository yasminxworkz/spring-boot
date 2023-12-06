package com.xworkz.HotelService.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xworkz.HotelService.dto.UserDTO;

@FeignClient(value = "User-Service", url = "http://localhost:8081")
public interface FeignHotelService {
	
	
	@GetMapping(value = "/api/user/{id}")
	UserDTO getUserById(@PathVariable("id") String userId);
	

}
