package com.xworkz.person;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration

public class SwaggerConfigurationClass {
	
	public SwaggerConfigurationClass() {
		System.err.println("running SwaggerConfigurationClass............. ");
	}
   
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xworkz.person.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    
   
}

