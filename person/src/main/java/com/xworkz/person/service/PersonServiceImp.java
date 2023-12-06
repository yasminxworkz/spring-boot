package com.xworkz.person.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.person.dto.PersonDTO;
import com.xworkz.person.repository.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonServiceImp implements PersonService {
	
	@Autowired
	PersonRepository repo;
	
	public PersonServiceImp() {
      log.info("running PersonServiceImp.................................");	}

	@Override
	public boolean onSave(PersonDTO dto) {
		
		
		if(dto.getAge()>50) {
			throw new ArithmeticException("sorry your age is not eligible");
		}
		
		
		repo.save(dto);
		return true;
	}

	@Override
	public List<PersonDTO> onFind() {
		log.info("running onFind in pesron ServiceImp..........");
		List<PersonDTO> list=repo.findAll();
		return list;
	}

	@Override
	public Optional<PersonDTO> findById(int id) {
		log.info("running findById in pesron ServiceImp..........");

		Optional<PersonDTO> list=repo.findById(id);
		
		return list;
	}

	@Override
	public boolean deleteById(int id) {
		log.info("running deleteById in pesron ServiceImp..........");

		repo.deleteById(id);
		return true;
	}

	@Override
	public void update(PersonDTO dto) {
		log.info("running update in pesron ServiceImp..........");

		repo.save(dto);
		
	}

	

	

	
	
	
	
	

}
