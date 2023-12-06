package com.xworkz.HotelService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xworkz.HotelService.entity.HotelEntity;

@Repository
public interface HotelRepo extends JpaRepository<HotelEntity, Long> {

}
