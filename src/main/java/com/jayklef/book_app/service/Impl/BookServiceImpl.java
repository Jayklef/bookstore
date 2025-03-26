package com.jayklef.book_app.service.Impl;

import com.jayklef.book_app.entity.Book;
import com.jayklef.book_app.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public List<Book> retrieveAllBook() {
        return null;
    }

    @Override
    public boolean updateBook(Long id, Book book) {
        return false;
    }


    @Override
    public Book deleteBook(Long id, Book book) {
        return null;
    }
}
