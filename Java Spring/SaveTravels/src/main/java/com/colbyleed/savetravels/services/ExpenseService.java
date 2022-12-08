package com.colbyleed.savetravels.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colbyleed.savetravels.models.Expense;
import com.colbyleed.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	ExpenseRepository expenseRepo;
	
//	CREATE EXPENSE
	public Expense create(Expense newExpense) {
		return expenseRepo.save(newExpense);
	}
	
//	GET ALL EXPENSES
	public List<Expense> getAllExpenses() {
		return expenseRepo.findAll();
	}
	
//	GET ONE EXPENSE
	public Expense findExpense(Long id) {
		return expenseRepo.findById(id).orElse(null);
	}
	
//	UPDATE AN EXPENSE
	public Expense updateExpense(@Valid Expense updatedExpense) {
		return expenseRepo.save(updatedExpense);
	}
	
//	DELETE AN EXPENSE
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
	
}
