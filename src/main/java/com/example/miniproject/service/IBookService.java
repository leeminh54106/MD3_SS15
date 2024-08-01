package com.example.miniproject.service;

import com.example.miniproject.entity.Book;
import com.example.miniproject.entity.Category;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(Integer id);
    boolean addBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(Integer id);
    List<Book> findByBookName(String bookName);
}
