package com.xworkz.person.schedular;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import com.xworkz.person.service.PersonService;

public class Schedular {

	PersonService service;
	
	@Async
	@Scheduled(fixedDelay = 10000, initialDelay = 1000)
	public void schedule() {
		System.err.println("testing schedular..................");
		
		
		
	}

}
