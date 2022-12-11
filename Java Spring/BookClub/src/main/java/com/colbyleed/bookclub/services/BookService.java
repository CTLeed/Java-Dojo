package com.colbyleed.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colbyleed.bookclub.models.Book;
import com.colbyleed.bookclub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	
//	---------------------------- CRUD FOR BOOKS -------------------------	//
	// CREATE
	public Book createBook(Book newBook) {
		return bookRepo.save(newBook);
	}
	
	// READ ONE
	public Book getOneBook(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	
	// READ ALL
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	
	// UPDATE
	public Book updateBook(Book updatedBook) {
		return bookRepo.save(updatedBook);
	}
	
	// DELETE
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
}
