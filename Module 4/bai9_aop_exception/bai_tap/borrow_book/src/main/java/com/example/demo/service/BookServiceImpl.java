package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book detail(int id) {
        Book book=bookRepository.findById(id).orElse(null);
        return book;
    }

    @Override
    public Book borrowBook(int id) {
        Book book=bookRepository.findById(id).orElse(null);
        if(book!=null){
            book.borrowBook();
        }
        return bookRepository.save(book);
    }

    @Override
    public Book returnBook(int id) {
        Book book=bookRepository.findById(id).orElse(null);
        if(book!=null){
            book.returnBook();
        }
        return bookRepository.save(book);
    }
}
