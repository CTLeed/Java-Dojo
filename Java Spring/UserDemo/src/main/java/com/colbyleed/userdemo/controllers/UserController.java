package com.colbyleed.userdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
