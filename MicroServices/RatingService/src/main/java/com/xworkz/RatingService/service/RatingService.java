package com.xworkz.RatingService.service;

import java.util.List;

import com.xworkz.RatingService.entity.Rating;

public interface RatingService {

	Rating onSave(Rating rating);
	
	Rating getRatingById(Long ratingId);
	
	 List<Rating> onFind();
	
	 boolean deleteById(Long ratingId);
	
	
	
	
	
	
	
	
	
	
}
