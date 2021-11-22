package com.springboot.book.springbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.springboot.book.springbook.Dao.BookRepository;
import com.springboot.book.springbook.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private static List<Book> list = new ArrayList<>();

    @Autowired
    private BookRepository bookRepository;

    static {
        list.add(new Book(12, "Java", "XYZ"));
        list.add(new Book(13, "JavaScript", "ABC"));
        list.add(new Book(14, "React", "POR"));
        list.add(new Book(15, "SpringBoot", "LMN"));
    }

    // get all BookService
    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // get single book
    public Book getBookById(int id) {
        Book book = null;
        try {

            book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;

    }

    // add books into list

    public Book addBook(Book book) {
        list.add(book);
        return book;
    }

    public void deleteBookById(int id) {
        list = list.stream().filter(e -> e.getId() != id).collect(Collectors.toList());

    }

    public void updateBookById(int bookId, Book book) {

        list = list.stream().map(b -> {
            if (b.getId() == bookId) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
