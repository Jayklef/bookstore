package com.jayklef.book_app.service;

import com.jayklef.book_app.entity.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> retrieveAllBook();

    boolean updateBook(Long id, Book book);

    boolean deleteBook(Long id);
}
