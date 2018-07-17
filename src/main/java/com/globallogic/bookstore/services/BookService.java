package com.globallogic.bookstore.services;

import java.util.List;

import com.globallogic.bookstore.domain.Book;
import com.globallogic.bookstore.model.BookDTO;

public interface BookService {
	
	List<BookDTO> getAllBooks();

	BookDTO getBookById(Long l);

}
