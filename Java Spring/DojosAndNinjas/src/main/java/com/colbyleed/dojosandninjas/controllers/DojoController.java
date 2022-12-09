package com.colbyleed.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.colbyleed.dojosandninjas.models.Dojo;
import com.colbyleed.dojosandninjas.services.MainService;

@Controller
public class DojoController {
	
	@Autowired
	MainService service;
	
	@GetMapping("/dojos")
	public String index(
			Model model
			) {
		model.addAttribute("allDojos", service.getAllDojos());
		return "index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(
			@ModelAttribute("dojoObject") Dojo emptyDojoObject
			) {
		return "createDojo.jsp";
	}
	
	@PostMapping("/dojos/new/process")
	public String processDojo( 
			@Valid @ModelAttribute("dojoObject") Dojo filledDojoObject,
			BindingResult results
			) {
		if(results.hasErrors()) {
			return "/dojos/new";
		}
		service.createDojo(filledDojoObject);
		return "redirect:/dojos/";
		
	}
	
	@GetMapping("/dojos/{id}")
	public String showOne(
			@PathVariable("id") Long id,
			Model model
			) {
		model.addAttribute("dojo", service.getOneDojo(id));
		return "oneDojo.jsp";
	}
	
	
}
