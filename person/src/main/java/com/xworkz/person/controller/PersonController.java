package com.xworkz.person.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.person.dto.PersonDTO;
import com.xworkz.person.service.PersonService;

import io.swagger.annotations.Api;

@RestController
@Api
@RequestMapping("/personController")

public class PersonController {

	@Autowired
	PersonService service;
	
	public PersonController() {
         System.err.println("running PersonController.........................");	
         }
	
	@GetMapping(value = "/run")
	public List<PersonDTO> onRun() {
		
		PersonDTO personDTO1=new PersonDTO(3,"moeen",27,"entrepreneur","bengaluru");
		PersonDTO personDTO2=new PersonDTO(4,"abbu",26,"engineer","bengaluru");
		PersonDTO personDTO3=new PersonDTO(5,"namrata",29,"scientist","gadag");
		PersonDTO personDTO4=new PersonDTO(6,"arfa",28,"analyst","kalsapur");

		List<PersonDTO> list=new ArrayList<PersonDTO>();
		list.add(personDTO4);
		list.add(personDTO3);
		list.add(personDTO2);
		list.add(personDTO1);
		
		return list;
	}
	
	@PostMapping
	public String onSave(@RequestBody PersonDTO dto) {
		service.onSave(dto);
		return "saved successfully";
	}
	
	@GetMapping
	public List<PersonDTO> onFindAll(){
		
		List<PersonDTO> list=service.onFind();
//		String str=null;
//		try {
//			System.out.println(str.length());
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
		return list;
  	}
	
	@GetMapping(value = "{id}" )
	public Optional<PersonDTO> findById(@PathVariable Integer id){
		System.err.println("==========================================================");
//		int[] arr= {1,2,3,4,5};
//		System.out.println(arr[6]);
		Optional<PersonDTO> list=service.findById(id);
		
		return list;
	}
	
	
	@DeleteMapping(value = "{id}" ,consumes  = MediaType.APPLICATION_JSON_VALUE)
	public String deleteById(@PathVariable Integer id){
		System.err.println("==========================================================");
		service.deleteById(id);
		
		return "deleted";
	}
	
	@PutMapping
	public PersonDTO onUpdate(@RequestBody PersonDTO dto) {
	    
		service.update(dto);
		
		return dto;
	}
	
	
	
	
	
}
