package com.xworkz.RatingService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.RatingService.entity.Rating;
import com.xworkz.RatingService.repository.RatingRepo;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class RatingServiceImp implements RatingService {

	@Autowired
	RatingRepo repo;
	
	
	public RatingServiceImp() {
		log.info("running RatingServiceImp......................");
	}


	@Override
	public Rating onSave(Rating rating) {
		log.info("running save in rating service.........");
		return repo.save(rating);
	}


	@Override
	public Rating getRatingById(Long ratingId) {
		log.info("running getRatingById in rating service....................");
		return repo.findById(ratingId).get();
	}


	@Override
	public List<Rating> onFind() {
		log.info("running deleteById in rating service....................");
		List<Rating> list=repo.findAll();
		return list;
	}


	@Override
	public boolean deleteById(Long ratingId) {
		
		log.info("running deleteById in rating service....................");

		repo.deleteById(ratingId);
		return true;
	}


	


	
	

}
