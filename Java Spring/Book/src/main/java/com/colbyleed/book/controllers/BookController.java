package com.colbyleed.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.colbyleed.book.models.Book;
import com.colbyleed.book.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;

	@GetMapping("/books")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		Book oneBook = bookService.findBook(id);
		System.out.println(oneBook);
		model.addAttribute("book", oneBook);
		return "onebook.jsp";
	}
	
}
