package com.colbyleed.bookclub.controllers;

import javax.servlet.http.HttpSession;
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

import com.colbyleed.bookclub.models.Book;
import com.colbyleed.bookclub.models.LoginUser;
import com.colbyleed.bookclub.models.User;
import com.colbyleed.bookclub.services.BookService;
import com.colbyleed.bookclub.services.UserService;

@Controller
public class MainController {
	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
//	INDEX, BIND EMPTY REGISTER USER AND LOGIN USER TO THEIR PERSPECTIVE FORMS
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
		User createdUser = userService.register(filledUser, results);
		if(results.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("user_id", createdUser.getId());		
		return "redirect:/books";
	}	
	
//	PROCESS LOGIN
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("newLogin") LoginUser filledLoginUser,
			BindingResult results,
			HttpSession session,
			Model model
			) {
		User loggedUser = userService.login(filledLoginUser, results);
		if(results.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		session.setAttribute("user_id", loggedUser.getId());
		return "redirect:/books";
	}
	
	@GetMapping("/books")
	public String dashboard(
			HttpSession session,
			Model model
			) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId == null) {
			return "redirect:/";
		}
		model.addAttribute("userObject", userService.getOneUser(userId));
		model.addAttribute("allBooks", bookService.getAllBooks());
		return "dashboard.jsp";
	}
	
//	ADD A NEW BOOK
	@GetMapping("/books/new")
	public String newBook(
			@ModelAttribute("bookObject") Book emptyBookObject
			) {
		
		return "newBook.jsp";
	}
	
	@PostMapping("/books/create")
	public String createBook(
			@Valid @ModelAttribute("bookObject") Book filledBookObject,
			BindingResult results
			) {
		bookService.createBook(filledBookObject);
		return "redirect:/books";
	}
	
//	SHOW ONE BOOK
	@GetMapping("/books/{id}")
	public String showOne(
			@PathVariable("id") Long bookId,
			Model model
			) {
		model.addAttribute("book", bookService.getOneBook(bookId));
		return "oneBook.jsp";
	}
	
//	EDIT / UPDATE BOOK
	@GetMapping("/books/{id}/edit")
	public String editBook(
			@PathVariable("id") Long bookId,
			Model model
			) {
		model.addAttribute("bookObject", bookService.getOneBook(bookId));
		return "editBook.jsp";
	}
	
	@PutMapping("books/{id}/edit")
	public String updateBook(
			@Valid @ModelAttribute("bookObject") Book filledBookObject,
			BindingResult results
			) {
		if(results.hasErrors()) {
			return "editBook.jsp";
		}
		bookService.updateBook(filledBookObject);
		return "redirect:/books";
	}
	
//	DELETE BOOK
	@DeleteMapping("/books/{id}")
	public String deleteBook(
			@PathVariable("id") Long bookId
			) {
		bookService.deleteBook(bookId);
		return "redirect:/books";
	}
	
//	LOGOUT
	@GetMapping("/logout")
	public String logout(
			HttpSession session
			) {
		session.removeAttribute("user_id");
		return "redirect:/";
	}
	
}
