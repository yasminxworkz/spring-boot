package com.xworkz.UserService.dto;

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
	private UserDTO user;
}
