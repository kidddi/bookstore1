package com.globallogic.bookstore.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.globallogic.bookstore.converters.BookDTOToBook;
import com.globallogic.bookstore.converters.BookToBookDTO;
import com.globallogic.bookstore.domain.Book;
import com.globallogic.bookstore.model.BookDTO;
import com.globallogic.bookstore.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	private int moneyEarned;
	
	private final BookToBookDTO bookToBookDto;
	private final BookDTOToBook bookDTOToBook;
	private final BookRepository bookRepository;

	public BookServiceImpl(BookToBookDTO bookToBookDto, BookDTOToBook bookDTOToBook, BookRepository bookRepository) {
		this.bookToBookDto = bookToBookDto;
		this.bookDTOToBook = bookDTOToBook;
		this.bookRepository = bookRepository;
	}

	@Override
	public List<BookDTO> getAllBooks() {

		return StreamSupport.stream(bookRepository.findAll()
				.spliterator(), true)
				.map(book -> bookToBookDto.convert(book))
				.collect(Collectors.toList());
	}

	@Override
	public BookDTO getBookById(Long l) {
		return bookToBookDto.convert(bookRepository.findById(l)
				.get());
	}

	@Override
	public BookDTO setBookIsBoughtById(Long l) {
		Book book = bookDTOToBook.convert(getBookById(l));

		book.buyBook();

		Book savedBook = bookRepository.save(book);
		
		moneyEarned += savedBook.getPrice();

		return bookToBookDto.convert(savedBook);
	}

	@Override
	public BookDTO setBookIsReturnedById(Long l) {
		Book book = bookDTOToBook.convert(getBookById(l));

		book.returnBook();
		
		Book savedBook = bookRepository.save(book);
		
		moneyEarned -= savedBook.getPrice();

		return bookToBookDto.convert(savedBook);
	}

	@Override
	public int getMoneyEarned() {		
		return moneyEarned;
	}

	@Override
	public BookDTO saveBookDto(BookDTO bookDto) {
		Book book = bookDTOToBook.convert(bookDto);
		
		Book savedBook = bookRepository.save(book);
		
		return bookToBookDto.convert(savedBook);
	}


}
