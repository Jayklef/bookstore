package com.jayklef.book_app.controller;

import com.jayklef.book_app.entity.Book;
import com.jayklef.book_app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book){
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }

    @GetMapping("/books")
    public List<Book> retrieveAllBook(){
        return bookRepository.findAll();
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable("id") Long id,
                           @RequestBody Book book){
        book.setId(id);
        return bookRepository.save(book);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Entity> deleteBook(@PathVariable("id") Long id,
                                             @RequestBody Book book){
        book.setId(id);
        bookRepository.delete(book);
        return ResponseEntity.ok().build();
    }
}
