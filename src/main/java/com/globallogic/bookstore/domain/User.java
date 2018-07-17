package com.globallogic.bookstore.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.globallogic.bookstore.model.BookDTO;

import lombok.Data;

@Data
@Component
public class User {
	private List<BookDTO> listBooks = new ArrayList<>();
	
	public void addBook(BookDTO book) {
		this.listBooks.add(book);
	}
	
	public void removeBook(BookDTO book) {
		this.listBooks.remove(book);
	}
}
