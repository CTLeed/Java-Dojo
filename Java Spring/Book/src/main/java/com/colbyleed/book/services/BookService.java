package com.colbyleed.book.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colbyleed.book.models.Book;
import com.colbyleed.book.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	
//	CREATE A BOOK
	public Book create(Book newBook) {
		return bookRepo.save(newBook);
	}
	
//	GET ALL BOOKS
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	
//	GET ONE BOOK
	public Book findBook(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	
//	UPDATE A BOOK
	public Book updateBook(@Valid Book updatedBook) {
		return bookRepo.save(updatedBook);
	}
	
//	DELETE A BOOK
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}

}
