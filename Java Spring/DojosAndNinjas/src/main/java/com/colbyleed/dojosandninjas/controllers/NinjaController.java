package com.colbyleed.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.colbyleed.dojosandninjas.models.Ninja;
import com.colbyleed.dojosandninjas.services.MainService;

@Controller
public class NinjaController {

		@Autowired
		MainService service;
		
		@GetMapping("/ninjas/new")
		public String newNinja(
				@ModelAttribute("ninjaObject") Ninja emptyNinjaObject,
				Model model
				) {
			model.addAttribute("allDojos", service.getAllDojos());
			return "createNinja.jsp";			
		}
		
		@PostMapping("/ninjas/new/process")
		public String createNinja(
				@Valid @ModelAttribute("ninjaObject") Ninja filledNinjaObject,
				BindingResult results,
				Model model
				) {
			if(results.hasErrors()) {
				model.addAttribute("allDojos", service.getAllDojos());
				return "/ninjas/new";
			}
			service.createNinja(filledNinjaObject);
			return "redirect:/dojos";
		}
}
