package com.globallogic.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.globallogic.bookstore.services.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	private final BookService bookService;	
	
    public HomeController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/user")
    public String userIndex(Model model) {
    	log.debug("Getting Index page");
    	
    	model.addAttribute("books", bookService.getAllBooks());
    	
        return "user/index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

}
