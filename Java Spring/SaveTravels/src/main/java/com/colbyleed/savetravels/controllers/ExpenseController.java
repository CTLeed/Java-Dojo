package com.colbyleed.savetravels.controllers;

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

import com.colbyleed.savetravels.models.Expense;
import com.colbyleed.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public String index(
			Model model,
			@ModelAttribute("expenseObject") Expense emptyExpenseObject
			) {
		List<Expense> allExpenses = expenseService.getAllExpenses();
		model.addAttribute("allExpenses", allExpenses);
		return "index.jsp";
	}
	
	@PostMapping("/expenses/new")
	public String processExpense(
			@Valid @ModelAttribute("expenseObject") Expense filledExpenseObject,
			BindingResult results,
			Model model
			) {
		if(results.hasErrors()) {
			List<Expense> allExpenses = expenseService.getAllExpenses();
			model.addAttribute("allExpenses", allExpenses);
			return "/expenses";
		}
		expenseService.create(filledExpenseObject);
		return "redirect:/expenses";		
	}
	
//	VIEW ONE EXPENSE
	@GetMapping("/expenses/{id}")
	public String showOne(
			@PathVariable("id") Long id,
			Model model
			) {
		Expense oneExpense = expenseService.findExpense(id);
		model.addAttribute("expense", oneExpense);
		return "showOne.jsp";
	}
	
//	UPDATE ONE EXPENSE
	@GetMapping("/expenses/{id}/edit")
	public String editExpense(
			@PathVariable("id") Long id,
			Model model
			) {
		Expense oneExpense = expenseService.findExpense(id);
		model.addAttribute("expenseObject", oneExpense);
		return "editExpense.jsp";		
	}
	
	@PutMapping("/expenses/{id}/edit")
	public String updateExpense(
			@Valid @ModelAttribute("expenseObject") Expense filledExpenseObject,
			BindingResult results
			) {
		if(results.hasErrors()) {			
			return "editExpense.jsp";
		}
		expenseService.create(filledExpenseObject);
		return "redirect:/expenses";
	}
	
//	DELETE EXPENSE
	@DeleteMapping("/expenses/{id}")
	public String deleteExpense(
			@PathVariable("id") Long id
			) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
}
