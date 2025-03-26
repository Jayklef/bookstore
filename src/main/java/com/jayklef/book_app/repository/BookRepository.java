package com.jayklef.book_app.repository;

import com.jayklef.book_app.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);
    List<Book> findByTitleContaining(String keyword);
    List<Book> findByPriceBetween(double minPrice, double maxPrice);
}
