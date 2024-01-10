package com.xworkz.person.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class PersonDTO {
	@Id
	private int id;
	private String name;
	private int age;
	private String profession;
	private String location;
	
	

}
