package com.xworkz.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xworkz.person.dto.PersonDTO;

@Repository
public interface PersonRepository extends JpaRepository<PersonDTO, Integer>{

}
