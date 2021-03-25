package com.springaspect.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private final IServiceGreeting service;
	
	public HelloController(IServiceGreeting service) {
		this.service = service;
	}
	
	@GetMapping("/{param}")
	public String index(@PathVariable String param) {
		return this.service.proceed(param);
	}

}
