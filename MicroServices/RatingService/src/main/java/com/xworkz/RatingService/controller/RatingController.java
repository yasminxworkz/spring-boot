package com.xworkz.RatingService.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.RatingService.entity.Rating;
import com.xworkz.RatingService.service.RatingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	RatingService service;
	
	public RatingController() {
		log.info("running RatingController..........");
	}
	
	@PostMapping
	public ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
		log.info("running save method in rating controller.........");
		Rating rate=service.onSave(rating);
		return new ResponseEntity<>(rate,HttpStatus.CREATED);
	}
	
	@GetMapping("{ratingId}")
	public ResponseEntity<Rating> getRatingById(@PathVariable Long ratingId){

		log.info("running getRatingById method in rating controller.........");

		Rating rating=service.getRatingById(ratingId);
		return ResponseEntity.ok(rating);
	}
	
	@GetMapping
	public List<Rating> onFind(){
		List<Rating> list= service.onFind();
		return list;
	}
	
	
	@PutMapping
	public ResponseEntity<Rating> onUpdate(@RequestBody Rating rating){
		log.info("running update method in rating controller.......................");
		Rating rate=service.onSave(rating);
		return ResponseEntity.ok(rate);
	}
	
	@DeleteMapping("{ratingId}")
	public boolean onDelete(@PathVariable Long ratingId) {
		log.info("running delete method in rating controller....................");
		service.deleteById(ratingId);
		return true;
	}
	

}
