package com.xworkz.UserService.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xworkz.UserService.dto.HotelDTO;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
	
	@GetMapping(value = "/hotels/hotelId")
	 HotelDTO getHotel(@PathVariable String hotelId);

}
