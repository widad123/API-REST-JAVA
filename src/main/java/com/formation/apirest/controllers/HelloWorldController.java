package com.formation.apirest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/")
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	public String sayHello() {
		return "Hello World";
	}

}
