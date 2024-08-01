package com.example.miniproject.controller.book;

import com.example.miniproject.entity.Book;
import com.example.miniproject.entity.Category;
import com.example.miniproject.service.IBookService;
import com.example.miniproject.service.impl.BookServiceImpl;
import com.example.miniproject.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "bookController" , value = "/book-controller")
@MultipartConfig (
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 25
)

public class bookController extends HttpServlet {
    IBookService bookService = new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "add":
                addBook(req, resp);
                break;
            case "edit":
                editBook(req, resp);
                break;
            case "delete":
                deleteBook(req, resp);
                break;
            case "detail":
                detailBook(req, resp);
                break;
            default:
                req.setAttribute("books", bookService.findAll());
                req.getRequestDispatcher("/WEB-INF/views/books/list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "add":
                saveBook(req, resp);
                break;
            case "edit":
                updateBook(req, resp);
                break;
            case "search":
                searchBook(req, resp);
                break;
            default:
                req.setAttribute("books", bookService.findAll());
                req.getRequestDispatcher("/WEB-INF/views/books/list.jsp").forward(req, resp);
        }
    }

    //do get
    private void addBook(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Category> listCategory = new CategoryServiceImpl().findAll();
        req.setAttribute("listCategory", listCategory);
        req.getRequestDispatcher("/WEB-INF/views/books/add.jsp").forward(req, resp);
    }

    private void editBook(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("bookEdit", bookService.findById(id));
        req.getRequestDispatcher("/WEB-INF/views/books/edit.jsp").forward(req, resp);
    }

    private void deleteBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        bookService.deleteBook(id);
        resp.sendRedirect("/book-controller");
    }

    private void detailBook(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("bookDetail", bookService.findById(id));
        req.getRequestDispatcher("/WEB-INF/views/books/detail.jsp").forward(req, resp);

    }
    //do post
    private void saveBook(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        int totalPages = Integer.parseInt(req.getParameter("totalPages"));
        int yearCreated = Integer.parseInt(req.getParameter("yearCreated"));
        String author = req.getParameter("author");
        boolean status = Boolean.parseBoolean(req.getParameter("status"));
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));

        String pathUpload = req.getServletContext().getRealPath("/upload/");
        File fileUpload = new File(pathUpload);
        if (!fileUpload.exists()) {
            fileUpload.mkdir();
        }

        // Xử lý upload ảnh
        Part part = req.getPart("image");
        String fileName = part.getSubmittedFileName();
        String image = "/upload/" + fileName;
        part.write(pathUpload + File.separator + fileName);

        Book book = new Book(null, name, price, stock, totalPages, yearCreated, author, status, image, categoryId);
        bookService.addBook(book);
        resp.sendRedirect("/book-controller");
    }

    private void updateBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

    private void searchBook(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String bookName = req.getParameter("bookName");
        List<Book> bookResult = bookService.findByBookName(bookName);
        req.setAttribute("books", bookResult);
        req.getRequestDispatcher("/WEB-INF/views/books/list.jsp").forward(req, resp);
    }
}
