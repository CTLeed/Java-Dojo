package com.colbyleed.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.colbyleed.savetravels.models.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long>{
//	GET ALL METHOD
	List<Expense> findAll();
	
//	CUSTOM QUERIES
}
