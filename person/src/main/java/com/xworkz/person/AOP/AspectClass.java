package com.xworkz.person.AOP;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.xworkz.person.dto.PersonDTO;

@Aspect
@Component
public class AspectClass {
	
  @Pointcut("execution(* com.xworkz.person.controller.PersonController.*(..))")
	public void loggingPointCut() {
		
	}
	
	
	
	
//	                              package of controller   * indicates any method of the controller, (..) indicates any number of parameters
	@Before(value = "execution(* com.xworkz.person.controller.PersonController.*(..))")
	public void beforeAdvice(JoinPoint joinpoint) {
		
		System.err.println("Request to " +joinpoint.getSignature() + " started at "+ new Date());
	}
	
	@After("loggingPointCut()")
	public void afterAdvice(JoinPoint joinpoint) {
		
		System.err.println("Request to " +joinpoint.getSignature() + " ended at "+ new Date());
	}
	
	
	
	
	
//	@Around(value = "execution(* com.xworkz.person.controller.PersonController.*(..))")
//	public void aroundAdvice(ProceedingJoinPoint joinpoint)  {
//		
//		System.err.println("Request to " +joinpoint.getSignature().getName() + " around method execution*** "+ new Date());
//	
//	    
//	
//	}
	
	@AfterReturning(value = "execution(* com.xworkz.person.controller.PersonController.onSave(..))", returning = "retVal")
	public void afterReturningAdvice(JoinPoint joinpoint, Object retVal) {
		
		System.out.println("method signature "+joinpoint.getSignature());
		
		System.err.println("business logic to save data executed sucessfully...... "+retVal.toString());
	}

	@AfterThrowing(value = "execution(* com.xworkz.person.controller.PersonController.onSave(..))", throwing =   "exception")
	public void afterThrowing(JoinPoint joinpoint, Exception exception) {
		
		System.err.println(exception.getMessage());
	}
}
