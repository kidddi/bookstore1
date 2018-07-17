package com.globallogic.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.globallogic.bookstore.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
