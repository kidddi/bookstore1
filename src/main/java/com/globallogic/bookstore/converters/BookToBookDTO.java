package com.globallogic.bookstore.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.globallogic.bookstore.domain.Book;
import com.globallogic.bookstore.model.BookDTO;

import lombok.Synchronized;

@Component
public class BookToBookDTO implements Converter<Book, BookDTO>{
	
    @Synchronized    
    @Override
    public BookDTO convert(Book book) {
        if (book == null) {
            return null;
        }

        final BookDTO bookDto = new BookDTO();
        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setPrice(book.getPrice());
        bookDto.setTimesBought(book.getTimesBought());
        return bookDto;
    }
}
