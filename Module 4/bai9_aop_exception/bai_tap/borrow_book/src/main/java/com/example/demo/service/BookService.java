package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(int id);

    void save(Book book);

    void delete(Book book);

    Book detail(int id);

    Book borrowBook(int id);

    Book returnBook(int id);
}
