package com.books.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.books.models.Book;
import com.books.services.BookService;

@RestController //only returning strings
public class BookController {
	private BookService bService;

	//constructor
	public BookController(BookService service) {
		this.bService = service;
	}
	
	//routes
	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Book> index(){
		return this.bService.getAllBooks();
	}
	
	@RequestMapping(value="/getOne/{id}", method = RequestMethod.GET)
	public Book getOne(@PathVariable("id") Long id){
		return this.bService.getSingleBook(id);
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public Book createOne(Book book){
		return this.bService.createBook(book);
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void deleteOne(@PathVariable("id") Long id){
		this.bService.deleteBook(id);
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
	public Book updateOne(Book book, @PathVariable("id") Long id){
		return this.bService.updateBook(book);
		//note: since we are using "this" we don't need to utilize the id when calling the update function but we still need to have it as an input!
	}
	
	
	
	
}
