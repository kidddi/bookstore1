package com.globallogic.bookstore.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.globallogic.bookstore.converters.BookToBookDTO;
import com.globallogic.bookstore.model.BookDTO;
import com.globallogic.bookstore.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	private final BookToBookDTO bookToBookDto;
	private final BookRepository bookRepository;
	
	
	public BookServiceImpl(BookToBookDTO bookToBookDto, BookRepository bookRepository) {
		this.bookToBookDto = bookToBookDto;
		this.bookRepository = bookRepository;
	}

	@Override
	public List<BookDTO> getAllBooks() {
		
		return bookRepository.findAll()
				.stream()
				.map(book -> bookToBookDto.convert(book))
				.collect(Collectors.toList());
	}

}
