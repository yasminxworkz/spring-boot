package com.xworkz.person.service;

import java.util.List;
import java.util.Optional;

import com.xworkz.person.dto.PersonDTO;

public interface PersonService {
	
	public boolean onSave(PersonDTO dto) ;
	
	public List<PersonDTO> onFind();
	
	public Optional<PersonDTO> findById(int id);
	
	public boolean deleteById(int id);
	
    public void update(PersonDTO dto);	

}
