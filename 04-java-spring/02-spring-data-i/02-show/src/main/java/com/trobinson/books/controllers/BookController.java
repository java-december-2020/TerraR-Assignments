package com.trobinson.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.trobinson.books.models.Book;
import com.trobinson.books.services.BookService;

@Controller
public class BookController {
    @Autowired
	private BookService bService;
    
    @GetMapping("/books")
    public String index(Model viewModel) {
        List<Book> books = this.bService.getAllBooks();
        viewModel.addAttribute("books", books);
        return "/books/index.jsp";
    }
    
    @GetMapping("/books/{id}")
    public String findBookByIndex(@PathVariable("id") Long id, Model viewModel) {
    	Book book = bService.getSingleBook(id);
        viewModel.addAttribute("book", book);
        return "showBook.jsp";
    }

   @GetMapping("/books/new")
   public String newBook(@ModelAttribute("book") Book book) {
       return "/books/new.jsp";
   }
    
   @PostMapping("/books")
   public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
       if (result.hasErrors()) {
           return "/books/new.jsp";
       } else {
           bService.createBook(book);
           return "redirect:/books";
       }
   }
   
   @GetMapping("/books/edit/{id}")
   public String editBook(@PathVariable("id") Long id, Model viewModel) {
       Book book = bService.getSingleBook(id);
       if (book != null){
           viewModel.addAttribute("book", book);
           return "editBook.jsp";
       }else{
           return "redirect:/books";
       }
   }

   
   
    
}
