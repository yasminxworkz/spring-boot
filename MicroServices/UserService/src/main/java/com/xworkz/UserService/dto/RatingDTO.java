package com.xworkz.UserService.dto;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class RatingDTO {

	private Long id;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	
	

}
