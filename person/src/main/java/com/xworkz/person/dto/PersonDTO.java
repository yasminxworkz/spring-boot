package com.xworkz.person.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
