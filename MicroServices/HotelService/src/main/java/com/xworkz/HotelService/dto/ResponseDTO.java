package com.xworkz.HotelService.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ResponseDTO {

	private RatingDTO ratingDTO;
	private HotelDTO hotelDTO;
	private UserDTO user;
}
