package com.xworkz.HotelService.dto;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {
	
	@Id
	private Long id;
	private String name;
	private String email;
	
	
	
	

}
