package com.colbyleed.otom.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.colbyleed.otom.models.Chef;
import com.colbyleed.otom.models.Dish;
import com.colbyleed.otom.services.MainService;

@Controller
public class MainController {

	@Autowired
	MainService mainServ;
	
	@GetMapping(value={"/", "/chef/new"})
	public String createChef(
			@ModelAttribute("chefObject")Chef emptyChefObject
			) {
		return "/chef/create.jsp";
	}
	
	@PostMapping("/chef/new")
	public String processChef(
			@Valid @ModelAttribute("chefObject") Chef filledChefObject,
			BindingResult results
			) {
		if(results.hasErrors()) {
			return "/chef/create.jsp";
		}
		mainServ.createChef(filledChefObject);
		return "redirect:/";		
	}
	
	@GetMapping("/dish/new")
	public String createDish(
			@ModelAttribute("dishObject")Dish emptyDishObject,
			Model model
			) {
		model.addAttribute("allChefs", mainServ.getAllChefs());
		return "/dish/create.jsp";
	}
	
	@PostMapping("/dish/new")
	public String processDish(
			@Valid @ModelAttribute("dishObject") Dish filledDishObject,
			BindingResult results,
			Model model
			) {
		if(results.hasErrors()) {
			model.addAttribute("allChefs", mainServ.getAllChefs());
			return "/dish/create.jsp";
		}
		mainServ.createDish(filledDishObject);
		return "redirect:/dish/new";		
	}
	
	@GetMapping("/chef/{id}")
	public String oneChef(
			@PathVariable("id") Long chefId,
			Model model
			) {
		Chef oneChef = mainServ.getOneChef(chefId);
		model.addAttribute("chef", oneChef);
		return "/chef/display.jsp";
	}
	
	
	
}
