package com.globallogic.bookstore.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.globallogic.bookstore.model.BookDTO;
import com.globallogic.bookstore.services.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdminController {	
	
	private final BookService bookService;

	public AdminController(BookService bookService) {
		this.bookService = bookService;
	}

    @GetMapping("/admin/books")
    public String adminIndex(Model model) {
    	log.debug("Getting Index page");
    	
    	model.addAttribute("books", bookService.getAllBooks());
    	
        return "admin/books";
    }
    
    @GetMapping("/admin/book/new")
    public String addBook(Model model) {
    	
    	model.addAttribute("book", new BookDTO());
    	
    	return "admin/bookform";
    }
    
    @PostMapping("book")
    public String save(@ModelAttribute("recipe") BookDTO bookDto){
    	bookService.saveBookDto(bookDto);
    	return "redirect:/admin/books";
    }
}
