package com.xworkz.UserService.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class HotelDTO {
	@Id
	private String id;
	private String name;
	private String location;
	

}
