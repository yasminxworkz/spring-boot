package com.xworkz.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;


@SpringBootApplication
@EnableScheduling



public class PersonApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PersonApplication.class, args);
	}

}
