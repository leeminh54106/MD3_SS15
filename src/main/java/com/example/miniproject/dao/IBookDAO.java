package com.example.miniproject.dao;

import com.example.miniproject.entity.Book;
import com.example.miniproject.entity.Category;

import java.util.List;

public interface IBookDAO {
    List<Book> findAll();
    Book findById(Integer id);
    boolean addBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(Integer id);
    List<Book> findByBookName(String bookName);
}
