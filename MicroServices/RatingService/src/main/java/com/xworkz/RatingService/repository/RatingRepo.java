package com.xworkz.RatingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xworkz.RatingService.entity.Rating;


@Repository
public interface RatingRepo extends JpaRepository<Rating, Long>{
	

}
