package com.globallogic.bookstore.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.globallogic.bookstore.domain.Book;
import com.globallogic.bookstore.model.BookDTO;

import lombok.Synchronized;

@Component
public class BookDTOToBook implements Converter<BookDTO, Book>{
	
    @Synchronized    
    @Override
    public Book convert(BookDTO bookDto) {
        if (bookDto == null) {
            return null;
        }

        final Book book = new Book();
        book.setId(bookDto.getId());
        book.setName(bookDto.getName());
        book.setPrice(bookDto.getPrice());
        book.setTimesBought(bookDto.getTimesBought());
        return book;
    }
}
