package com.xworkz.person;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
@Configuration

@OpenAPIDefinition(
		
		info=@Info(
				title = "Person API",
				description = "Doing Crud Operation",
				summary = "This person api will add,read,update,delete details of a person",
				contact = @Contact(
						name = "x-workz",
						email = "yasmin.xworkz@gmail.com"
						),
				version = "v1"
				
				
				)	
		)
		

public class SwaggerConfigurationClass {
	
	public SwaggerConfigurationClass() {
		System.err.println("running SwaggerConfigurationClass............. ");
	}
   


	
	
	
   
}

