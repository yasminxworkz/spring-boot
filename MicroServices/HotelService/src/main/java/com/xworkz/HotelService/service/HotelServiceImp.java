package com.xworkz.HotelService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xworkz.HotelService.dto.HotelDTO;
import com.xworkz.HotelService.dto.RatingDTO;
import com.xworkz.HotelService.dto.ResponseDTO;
import com.xworkz.HotelService.dto.UserDTO;
import com.xworkz.HotelService.entity.HotelEntity;
import com.xworkz.HotelService.repository.HotelRepo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class HotelServiceImp implements HotelService {
	
	@Autowired
	private HotelRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private 	FeignHotelService feign;
	
	public HotelServiceImp() {
        log.info("running HotelServiceImp..........");
	}

	@Override
	public HotelEntity saveHotel(HotelEntity hotel) {
		log.info("running save in hotel Service..........");
		return repo.save(hotel);
	}


	@Override
	public ResponseDTO getRating(Long HotelRating) {
		log.info("running getById in hotel Service.........");
		ResponseDTO response=new ResponseDTO();
		HotelEntity rating=repo.findById(HotelRating).get();
		
		HotelDTO hotelDTO=mapToUser(rating);
		
		
		
		ResponseEntity<RatingDTO> responseEntity=restTemplate.getForEntity("http://localhost:8082/rating/"+rating.getRatingId(), RatingDTO.class);
		RatingDTO RatingDTO=responseEntity.getBody();
		
		log.info(""+responseEntity.getStatusCode());

		
		
		response.setHotelDTO(hotelDTO);
	
		response.setRatingDTO(RatingDTO);
		
		return response;
		
	
		
		
	}

	private HotelDTO mapToUser(HotelEntity hotel) {
		HotelDTO dto=new HotelDTO();
		dto.setId(hotel.getId());
		dto.setLocation(hotel.getLocation());
		dto.setName(hotel.getName());
		return dto;
	}

	


	@Override
	public ResponseDTO getHotel(Long hotelId) {
		log.info("running getById in hotel Service.........");
		ResponseDTO response=new ResponseDTO();
		HotelEntity hotel=repo.findById(hotelId).get();
		HotelDTO hotelDTO=mapToUser(hotel);
		
		ResponseEntity<UserDTO> responseEntity=restTemplate.getForEntity("http://localhost:8081/api/user/"+hotel.getUserId(), UserDTO.class);
		UserDTO userDTO=responseEntity.getBody();
		
		log.info(""+responseEntity.getStatusCode());
		
		response.setHotelDTO(hotelDTO);
		response.setUser(userDTO);
		
		return response;
		
	
		
		
	}

	@Override
	public List<HotelEntity> findAll() {
		log.info("running findAll in hotelService............");
		List<HotelEntity> list=repo.findAll();
		return list;
	}

	

	@Override
	public ResponseDTO getFHotel(Long hotelId) {
		log.info("running getById in hotel Service.........");
		ResponseDTO response=new ResponseDTO();
		HotelEntity hotel=repo.findById(hotelId).get();
		HotelDTO hotelDTO=mapToUser(hotel);
		
		
		UserDTO userDTO=feign.getUserById(hotel.getUserId());
		
		
		
		response.setHotelDTO(hotelDTO);
		response.setUser(userDTO);
		
		return response;
				
	}

	
	
	
	
	

}
