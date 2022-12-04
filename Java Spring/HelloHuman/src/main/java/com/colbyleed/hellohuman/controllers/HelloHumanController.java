package com.colbyleed.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {

	@RequestMapping("")
	public String welcome() {
		return "Hello Human";
	}
	
	@RequestMapping("/")
	public String helloName(@RequestParam(value="name", required=false) String queryName, 
		@RequestParam(value="last_name", required=false) String queryLastName)
	{	
		String firstName = "";
		String lastName = "";
		if(queryName != null) {
			firstName = queryName;
		}
		if(queryLastName != null) {
			lastName = queryLastName;
		}
		return "Hello " + firstName + " " + lastName;
	}
}
