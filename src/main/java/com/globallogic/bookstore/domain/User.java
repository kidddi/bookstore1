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
	private int totalPrice;
	
	public void addBook(BookDTO book) {
		this.listBooks.add(book);
	}
	
	public void removeBook(Long l) {
		for(BookDTO bookDto : listBooks) {
			if(bookDto.getId().equals(l)) {
				listBooks.remove(bookDto);
				break;
			}
		}
		//this.listBooks.remove(book);
	}
	
	public int calculateTotalPrice() {
		totalPrice = 0;
		this.listBooks.forEach(book -> totalPrice += book.getPrice());
		return totalPrice;
	}
}
