package com.jayklef.book_app.controller;

import com.jayklef.book_app.entity.Book;
import com.jayklef.book_app.repository.BookRepository;
import com.jayklef.book_app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<String> createBook(@RequestBody Book book){
        Book savedBook = bookService.save(book);
        return new ResponseEntity<>("savedBook", HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> retrieveAllBook(){
        List<Book> books = bookService.retrieveAllBook();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<String> updateBook(@PathVariable("id") Long id,
                           @RequestBody Book book){
        boolean bookToUpdate = bookService.updateBook(id, book);
        if (bookToUpdate){
        return new ResponseEntity<>("Book with id of: " + id + "updated correctly", HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long id,
                                             @RequestBody Book book){
        Book bookToDelete = bookService.deleteBook(id, book);
        return  new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
    }
}
