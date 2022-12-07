package com.colbyleed.userdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.colbyleed.userdemo.models.User;
import com.colbyleed.userdemo.services.UserService;

@Controller
public class UserController {

//	IMPORT OUR SERVICE / DEPENDENCY INJECTION
	@Autowired
	UserService userServ;
	
	@GetMapping("/")
	public String index(Model model) {
//		USE SERVICE TO MAKE CRUD COMMAND - RETRIEVE ALL USERS
		List<User> allUsersFromDB = userServ.getAllUsers();
		
//		PASS ALL USERS TO THE JSP
		model.addAttribute("allUsers", allUsersFromDB);
		
//		RENDER JSP
		return "index.jsp";
	}
	
//	CREATE A USER
	@PostMapping("/users/new")
	public String create(
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("age") Integer age
			) {
		User newUser = new User(email, password, age, name);
		userServ.create(newUser);
		return "redirect:/";
	}
	
//	VIEW ONE USER
	@GetMapping("/users/{id}")
	public String showOne(
			@PathVariable("id") Long id,
			Model model
			) {
//		RETRIEVE USER FROM DB
		User oneUser = userServ.findUser(id);
		
//		PASS INFORMATION TO THE JSP
		model.addAttribute("user", oneUser);
		return "oneUser.jsp";
	}
	
}
