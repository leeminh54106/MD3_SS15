package com.example.miniproject.dao.impl;

import com.example.miniproject.dao.IBookDAO;
import com.example.miniproject.entity.Book;
import com.example.miniproject.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements IBookDAO {

    @Override
    public List<Book> findAll() {
        Connection con = ConnectionDB.openConnection();
        List<Book> books = new ArrayList<>();
        try {
            CallableStatement cs = con.prepareCall("{call get_all_books()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setCategoryId(rs.getInt("categoryId"));
                book.setName(rs.getString("name"));
                book.setPrice(rs.getDouble("price"));
                book.setStock(rs.getInt("stock"));
                book.setTotalPages(rs.getInt("totalPages"));
                book.setYearCreated(rs.getInt("yearCreated"));
                book.setAuthor(rs.getString("author"));
                book.setStatus(rs.getBoolean("status"));
                book.setImage(rs.getString("image"));
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(con);
        }
        return books;
    }

    @Override
    public Book findById(Integer id) {
        Connection con = ConnectionDB.openConnection();

        try {
            CallableStatement cs = con.prepareCall("{call get_book_by_id(?)}");
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setCategoryId(rs.getInt("categoryId"));
                book.setName(rs.getString("name"));
                book.setPrice(rs.getDouble("price"));
                book.setStock(rs.getInt("stock"));
                book.setTotalPages(rs.getInt("totalPages"));
                book.setYearCreated(rs.getInt("yearCreated"));
                book.setAuthor(rs.getString("author"));
                book.setStatus(rs.getBoolean("status"));
                book.setImage(rs.getString("image"));
                return book;
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(con);
        }
    }

    @Override
    public boolean addBook(Book book) {
        Connection con = ConnectionDB.openConnection();

        try {
            CallableStatement cs = con.prepareCall("{call insert_book(?, ?, ?, ?, ? ,?, ?, ? ,?)}");
            cs.setInt(1, book.getCategoryId());
            cs.setString(2, book.getName());
            cs.setDouble(3, book.getPrice());
            cs.setInt(4, book.getStock());
            cs.setInt(5, book.getTotalPages());
            cs.setInt(6, book.getYearCreated());
            cs.setString(7, book.getAuthor());
            cs.setBoolean(8, book.isStatus());
            cs.setString(9, book.getImage());
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(con);
        }
    }

    @Override
    public boolean updateBook(Book book) {
        Connection con = ConnectionDB.openConnection();

        try {
            CallableStatement cs = con.prepareCall("{call update_book(?, ?, ?, ?, ?, ?, ? ,?, ?, ?)}");
            cs.setInt(1, book.getId());
            cs.setInt(2, book.getCategoryId());
            cs.setString(3, book.getName());
            cs.setDouble(4, book.getPrice());
            cs.setInt(5, book.getStock());
            cs.setInt(6, book.getTotalPages());
            cs.setInt(7, book.getYearCreated());
            cs.setString(8, book.getAuthor());
            cs.setBoolean(9, book.isStatus());
            cs.setString(10, book.getImage());
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(con);
        }
    }

    @Override
    public boolean deleteBook(Integer id) {
        Connection con = ConnectionDB.openConnection();

        try {
            CallableStatement cs = con.prepareCall("{call delete_book(?)}");
            cs.setInt(1, id);
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(con);
        }

    }

    @Override
    public List<Book> findByBookName(String bookName) {
        Connection con = ConnectionDB.openConnection();
        List<Book> books = new ArrayList<>();

        try {
            CallableStatement cs = con.prepareCall("{call get_book_by_name(?)}");
            if (bookName == null || bookName.isEmpty()) {
                bookName = "%";
            }
            else {
                bookName = "%" + bookName + "%";
            }
            cs.setString(1, bookName);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setCategoryId(rs.getInt("categoryId"));
                book.setName(rs.getString("name"));
                book.setPrice(rs.getDouble("price"));
                book.setStock(rs.getInt("stock"));
                book.setTotalPages(rs.getInt("totalPages"));
                book.setYearCreated(rs.getInt("yearCreated"));
                book.setAuthor(rs.getString("author"));
                book.setStatus(rs.getBoolean("status"));
                book.setImage(rs.getString("image"));
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(con);
        }
        return books;
    }
}
