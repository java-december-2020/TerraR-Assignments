package com.trobinson.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trobinson.books.models.Book;
import com.trobinson.books.services.BookService;

@RestController
@RequestMapping("/api")
public class BookControllerAPI {
    @Autowired
	private BookService bService;

    @GetMapping("")
    public List<Book> allBooks() {
        return this.bService.getAllBooks();
    }

	// Return Single Book by Id
	@GetMapping("{id}")
	public Book getOneBook(@PathVariable("id") Long id) {
		return this.bService.getSingleBook(id);
	}
    
    @PostMapping("")
    public Book create(Book newBook) {
        return this.bService.createBook(newBook);
    }   
}
