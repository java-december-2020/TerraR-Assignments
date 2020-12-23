package com.trobinson.books.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trobinson.books.models.Book;
import com.trobinson.books.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
   private final BookRepository bRepo;
    
   // Constructor
   public BookService(BookRepository bookRepository) {
       this.bRepo = bookRepository;
   }
    
    //Methods
    
    // Retrieve All
    public List<Book> getAllBooks() {
        return this.bRepo.findAll();
    }
    // Create
    public Book createBook(Book newBook) {
        return this.bRepo.save(newBook);
    }
    
    // Read
    public Book getSingleBook(Long id) {
        return this.bRepo.findById(id).orElse(null);
    }
    
	// Update
	public Book updateBook(Book updatedBook) {
		return this.bRepo.save(updatedBook);
	}

	// Delete
	public void deleteBook(Long id) {
		this.bRepo.deleteById(id);
	}
	
}
