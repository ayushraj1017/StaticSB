package com.springboot.book.springbook.Dao;

import com.springboot.book.springbook.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
