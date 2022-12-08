package com.colbyleed.userdemo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.colbyleed.userdemo.models.User;
import com.colbyleed.userdemo.services.UserService;

@Controller
public class UserController {

//	IMPORT OUR SERVICE / DEPENDENCY INJECTION
	@Autowired
	UserService userServ;
	
	@GetMapping("/")
	public String index(
			Model model,
			@ModelAttribute("userObject") User emptyUserObject
			) {
//		USE SERVICE TO MAKE CRUD COMMAND - RETRIEVE ALL USERS
		List<User> allUsersFromDB = userServ.getAllUsers();
		
//		PASS ALL USERS TO THE JSP
		model.addAttribute("allUsers", allUsersFromDB);
		
//		RENDER JSP
		return "index.jsp";
	}
	
//	CREATE A USER
	@PostMapping("/users/new")
	public String processUser(
			@Valid @ModelAttribute("userObject") User filledUserObject,
			BindingResult results,
			Model model
			) {
		if(results.hasErrors()) {
			List<User> allUsersFromDB = userServ.getAllUsers();
			model.addAttribute("allUsers", allUsersFromDB);
			return "index.jsp";
		}
		userServ.create(filledUserObject);
		return "redirect:/";
	}
	
	
//	--------------------- DATA BINDING (CREATE) ------------------------------- //
//	@GetMapping("/users/new/dataBinding")
//	public String newUser(
//			@ModelAttribute("userObject") User emptyUserObject
//	) {
//		return "create.jsp";
//	}
	
//	@PostMapping("/users/new/dataBinding")
//	public String processUser(
//			@Valid @ModelAttribute("userObject") User filledUserObject,
//			BindingResult results
//			) {
//		if(results.hasErrors()) {
//			return "create.jsp";
//		}
//		userServ.create(filledUserObject);
//		return "redirect:/";
//	}
		
	
//	--------------------- DATA BINDING (CREATE)------------------------------- //

//	--------------------- DATA BINDING (UPDATE) ------------------------------- //
	
	@GetMapping("/users/{id}/edit")
	public String editUser(
			@PathVariable("id") Long userId,
			Model model
			) {
//		GRAB ONE USER FROM DB
		User oneUser = userServ.findUser(userId);
//		PASS ONE USER TO JSP
		model.addAttribute("userObject", oneUser);
		return "editUser.jsp";
	}
	@PutMapping("/users/{id}/edit")
	public String updateUser(
		@Valid @ModelAttribute("userObject") User filledUserObject,
		BindingResult results
		) {
	if(results.hasErrors()) {
		return "editUser.jsp";
	}
	userServ.create(filledUserObject);
	return "redirect:/";
	}
	
	
//	--------------------- DATA BINDING (UPDATE) ------------------------------- //
	
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
	
	@DeleteMapping("/users/{id}")
	public String deleteUser(
			@PathVariable("id") Long userId
			) {
		userServ.deleteUser(userId);
		return "redirect:/";
	}
	
}
