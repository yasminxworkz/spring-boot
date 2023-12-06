package com.xworkz.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.xworkz.person.Calculator;
import com.xworkz.person.service.PersonServiceImp;

@SpringBootTest
class PersonApplicationTests {

	
	
private Calculator c=new Calculator();
	
	
	@Test
	void contextLoads() {
	}

	@Test
	void testSum() {
		int expected=10;
		
		int actualResult=c.doSum(5, 3, 2);
        assertEquals(actualResult, expected);
        System.out.println("running testSum...............");
	}
	
	@Test
	void testProd() {
		 int expected=20;
		 
		 int actual=c.doProd(5, 4);
	        assertEquals(actual, expected);

		
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("running tearDown.............");
	}
	
	@BeforeEach
	void setUp() {
		
		System.out.println("running setUp.............");

	}
	
	
	
	
	

}
