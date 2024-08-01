package com.example.miniproject.service.impl;

import com.example.miniproject.dao.IBookDAO;
import com.example.miniproject.dao.impl.BookDAOImpl;
import com.example.miniproject.entity.Book;
import com.example.miniproject.service.IBookService;

import java.util.List;

public class BookServiceImpl implements IBookService {

    IBookDAO bookDAO = new BookDAOImpl();
    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookDAO.findById(id);
    }

    @Override
    public boolean addBook(Book book) {
        return bookDAO.addBook(book);
    }

    @Override
    public boolean updateBook(Book book) {
        return bookDAO.updateBook(book);
    }

    @Override
    public boolean deleteBook(Integer id) {
        return bookDAO.deleteBook(id);
    }

    @Override
    public List<Book> findByBookName(String bookName) {
        return bookDAO.findByBookName(bookName);
    }
}
