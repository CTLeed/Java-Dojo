package com.colbyleed.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping("/omikuji")
	public String form() {
		return "index.jsp";
	}
	
	@PostMapping("/omikuji/process")
	public String formProcess(
		@RequestParam("number") Integer number,
		@RequestParam("city") String city,
		@RequestParam("person") String person,
		@RequestParam("hobby") String hobby,
		@RequestParam("livingThing") String livingThing,
		@RequestParam("niceThing") String niceThing,
		HttpSession session
		) {
		session.setAttribute("sessionNumber", number);
		session.setAttribute("sessionCity", city);
		session.setAttribute("sessionPerson", person);
		session.setAttribute("sessionHobby", hobby);
		session.setAttribute("sessionLivingThing", livingThing);
		session.setAttribute("sessionNiceThing", niceThing);		
		return "redirect:/omikuji/show";
	}
	
	@GetMapping("/omikuji/show")
	public String showOmikuji(Model model, HttpSession session) {
		model.addAttribute("number", session.getAttribute("sessionNumber"));
		model.addAttribute("city", session.getAttribute("sessionCity"));
		model.addAttribute("person", session.getAttribute("sessionPerson"));
		model.addAttribute("hobby", session.getAttribute("sessionHobby"));
		model.addAttribute("livingThing", session.getAttribute("sessionLivingThing"));
		model.addAttribute("niceThing", session.getAttribute("sessionNiceThing"));
		return "show.jsp";
	}
}
