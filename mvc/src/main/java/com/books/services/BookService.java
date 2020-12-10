package com.books.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.books.models.Book;
import com.books.repositories.BookRepository;

@Service
public class BookService {
	//Dependency Injection - adding the book repository as a dependency
	private BookRepository bRepo;

	//constructor
	public BookService(BookRepository repo) {
		this.bRepo = repo;
	}
	
	//Custom CRUD methods:
	//Get All Books
	public List<Book> getAllBooks(){
		return this.bRepo.findAll();
	}
	
	//Get one book
	public Book getSingleBook(Long id) {
		return this.bRepo.findById(id).orElse(null);
		//if doesn't find item, it will return null
	}
	
	//Create a new book
	public Book createBook(Book newBook) {
		return this.bRepo.save(newBook);
	}
	
	//delete a book
	public void deleteBook(Long id) {
		this.bRepo.deleteById(id);
	}
	
	//update a book
	public Book updateBook(Book book) {
		return this.bRepo.save(book);
	}
	
	
	
}
