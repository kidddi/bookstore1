package com.globallogic.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globallogic.bookstore.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
