package com.colbyleed.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.colbyleed.book.models.Book;
import com.colbyleed.book.services.BookService;

@RestController
public class BooksApi {
	
	@Autowired
	BookService bookServ;
	
	@GetMapping("/api/books")
	public List<Book> getAll() {
		return bookServ.getAllBooks();
		  
		
	}
	
	@PostMapping("/api/books")
	public Book create(
			@RequestParam("title") String title,
			@RequestParam("description") String desc,
			@RequestParam("language") String lang,
			@RequestParam("numOfPages") Integer numOfPages
			) {
		Book newBook = new Book(title, desc, lang, numOfPages);
		return bookServ.create(newBook);
	}
	
	
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	public Book update(
			@PathVariable("id") Long id,
			@RequestParam("title") String title,
			@RequestParam("description") String desc,
			@RequestParam("language") String lang,
			@RequestParam("numOfPages") Integer numOfPages
			) {
		Book book = bookServ.updateBook(title, desc, lang, numOfPages);
		return book;		
	}
	
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) {
		bookServ.deleteBook(id);
	}	

}
