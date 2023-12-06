package com.xworkz.HotelService.service;


import java.util.List;

import com.xworkz.HotelService.dto.ResponseDTO;
import com.xworkz.HotelService.entity.HotelEntity;

public interface HotelService {

	HotelEntity saveHotel(HotelEntity hotel);
	
	ResponseDTO getHotel(Long hotelId);
	
	ResponseDTO getFHotel(Long hotelId);

	ResponseDTO getRating(Long HotelRating);
	
	List<HotelEntity> findAll();
	
	
	
	
	
	
	
	
}
