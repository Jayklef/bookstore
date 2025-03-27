package com.jayklef.book_app.service.Impl;

import com.jayklef.book_app.entity.Book;
import com.jayklef.book_app.repository.BookRepository;
import com.jayklef.book_app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> retrieveAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public boolean updateBook(Long id, Book book) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()){
            Book bookToUpdate = optionalBook.get();
            bookToUpdate.setTitle(book.getTitle());
            bookToUpdate.setAuthor(book.getAuthor());
            bookToUpdate.setPrice(book.getPrice());
            bookToUpdate.setImageUrl(book.getImageUrl());

            bookRepository.save(book);
            return  true;
        }
        return false;
    }


    @Override
    public boolean deleteBook(Long id) {

        try {
            bookRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
