package com.springaspect.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springaspect.demo.aop.Auditoria;

@Service
public class ServiceGreeting implements IServiceGreeting{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Auditoria
	@Override
	public String proceed(String param) {
		logger.info("Greeting service exec in {}", System.currentTimeMillis());
		return "Greetings from Spring Boot! Esta é uma msg de " + param;
	}

}
