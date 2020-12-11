package com.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.books.models.Book;
import com.books.services.BookService;

@Controller
public class HomeController {
    private final BookService bookService;
    
    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }
    
    //When a user visits "/books", we want to show them all the books that we have in our database.
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        
        return "/books/index.jsp";
    }

    //When the user visits "/books/new", we want to show them the form to create the book.
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }
    
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    
    //when the user visits '/books/1', you are to respond with a view page that has all the information about a specific book.
    @RequestMapping("/books/{id}")
    public String displayOne(@PathVariable("id") Long id, Model model) {
        Book selected_book = bookService.getSingleBook(id);
        model.addAttribute("selected_book", selected_book);
        
        return "/books/display.jsp";
    }
    

}
