package com.colbyleed.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "Hello user!";
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
	
	@RequestMapping("/goodbye")
	public String goodbye() {
		return "Goodbye";
	}
}
