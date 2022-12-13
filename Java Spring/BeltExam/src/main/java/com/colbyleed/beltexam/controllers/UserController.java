package com.colbyleed.beltexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.colbyleed.beltexam.models.LoginUser;
import com.colbyleed.beltexam.models.User;
import com.colbyleed.beltexam.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userServ;
	
	@GetMapping("/")
	public String index(
			@ModelAttribute("newUser") User emptyUser,
			@ModelAttribute("newLogin") User emptyLoginUser
			) {
		return "index.jsp";
	}
	
	
//	PROCESS REGISTER
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("newUser") User filledUser,
			BindingResult results,
			HttpSession session,
			Model model
			) {
		User createdUser = userServ.register(filledUser, results);
		if(results.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
//		SAVE THE USERS ID IN SESSION
		session.setAttribute("user_id", createdUser.getId());
		return "redirect:/homepage";
		
	}
	
//	PROCESS LOGIN
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("newLogin") LoginUser filledLoginUser,
			BindingResult results,
			HttpSession session,
			Model model
			) {
		User loggedUser = userServ.login(filledLoginUser, results);
		if(results.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		session.setAttribute("user_id", loggedUser.getId());
		return "redirect:/homepage";		
	}
	
	@GetMapping("/homepage")
	public String homepage(
			HttpSession session,
			Model model
			) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId == null) {
			return "redirect:/";
		}
		model.addAttribute("userObject", userServ.getOneUser(userId));
		return "dashboard.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(
			HttpSession session
			) {
		session.removeAttribute("user_id");
		return "redirect:/";
	}
	
	
}