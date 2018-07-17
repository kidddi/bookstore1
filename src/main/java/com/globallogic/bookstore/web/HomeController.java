package com.globallogic.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.globallogic.bookstore.domain.User;
import com.globallogic.bookstore.services.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	private final BookService bookService;	
	private final User user;    

	public HomeController(BookService bookService, User user) {
		this.bookService = bookService;
		this.user = user;
	}

    @GetMapping("/user/books")
    public String userIndex(Model model) {
    	log.debug("Getting Index page");
    	
    	model.addAttribute("books", bookService.getAllBooks());
    	model.addAttribute("userBooks", user.getListBooks());
    	model.addAttribute("totalPrice", user.calculateTotalPrice());
    	model.addAttribute("moneyEarned", bookService.getMoneyEarned());
    	
        return "user/books";
    }
    
    @GetMapping("/book/{id}/buy")
    public String buyBook(@PathVariable String id) {
    	
    	user.addBook(bookService.getBookById(Long.valueOf(id)));
    	bookService.setBookIsBoughtById(Long.valueOf(id));
    	return "redirect:/user/books";
    }
    
    @GetMapping("/user/book/{id}/checkout")
    public String checkoutBook(@PathVariable String id) {
    	
    	user.removeBook(Long.valueOf(id));
    	bookService.setBookIsReturnedById(Long.valueOf(id));
    	
    	return "redirect:/user/books";
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
