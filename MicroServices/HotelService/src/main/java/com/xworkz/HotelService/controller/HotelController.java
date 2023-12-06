package com.xworkz.HotelService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.HotelService.dto.ResponseDTO;
import com.xworkz.HotelService.entity.HotelEntity;
import com.xworkz.HotelService.service.HotelService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/hotel")
@Slf4j
@AllArgsConstructor
public class HotelController {

	
    @Autowired
	private HotelService hotelservice;
	
	public HotelController() {
		log.info("running HotelController...................");
	}
	
	@PostMapping
	public ResponseEntity<HotelEntity> saveHotel(@RequestBody HotelEntity hotel){
		HotelEntity entity=hotelservice.saveHotel(hotel);
		return new ResponseEntity<>(entity,HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{HotelId}")
	public ResponseEntity<ResponseDTO> getUser(@PathVariable Long HotelId){
		ResponseDTO dto=hotelservice.getHotel(HotelId);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/customer/{HotelId}")
	public ResponseEntity<ResponseDTO> getFUser(@PathVariable Long HotelId){
		ResponseDTO dto=hotelservice.getHotel(HotelId);
		System.err.println(dto);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("{HotelRating}")
	public ResponseEntity<ResponseDTO> getRating(@PathVariable Long HotelRating){
		ResponseDTO dto=hotelservice.getRating( HotelRating);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public List<HotelEntity> findAll(){
		List<HotelEntity> list=hotelservice.findAll();
		return list;
	}
	
	@PutMapping
	public ResponseEntity<HotelEntity> onUpdate(@RequestBody HotelEntity entity){ 
	HotelEntity response=hotelservice.saveHotel(entity);
		return ResponseEntity.ok(response);
	}
	
	

	
	
}
