package com.example.miniproject.controller.category;

import com.example.miniproject.entity.Category;
import com.example.miniproject.service.ICategoryService;
import com.example.miniproject.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "categoryController" , value = "/category-controller")
public class categoryController extends HttpServlet {

    ICategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "add":
                addCategory(req, resp);
                break;
            case "edit":
                editCategory(req, resp);
                break;
            case "delete":
                deleteCategory(req, resp);
                break;
            case "detail":
                detailCategory(req, resp);
                break;
            default:
                req.setAttribute("categories", categoryService.findAll());
                req.getRequestDispatcher("/WEB-INF/views/categories/list.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "add":
                saveCategory(req, resp);
                break;
            case "edit":
                updateCategory(req, resp);
                break;
            case "search":
                searchCategory(req, resp);
                break;
            default:
                req.setAttribute("categories", categoryService.findAll());
                req.getRequestDispatcher("/WEB-INF/views/categories/list.jsp").forward(req, resp);
        }
    }

    //Do get
    private void addCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/categories/add.jsp").forward(req, resp);
    }

    private void editCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("categoryEdit", categoryService.findById(id));
        req.getRequestDispatcher("/WEB-INF/views/categories/edit.jsp").forward(req, resp);
    }

    private void deleteCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        categoryService.deleteCategory(id);
        resp.sendRedirect("/category-controller");
    }

    private void detailCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("categoryDetail", categoryService.findById(id));
        req.getRequestDispatcher("/WEB-INF/views/categories/detail.jsp").forward(req, resp);
    }


    //Do post
    private void saveCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        boolean status = Boolean.parseBoolean(req.getParameter("status"));
        Category category = new Category(null, name, status);
        categoryService.addCategory(category);
        resp.sendRedirect("/category-controller");
    }

    private void updateCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        boolean status = Boolean.parseBoolean(req.getParameter("status"));
        Category category = new Category(id, name, status);
        categoryService.updateCategory(category);
        resp.sendRedirect("/category-controller");
    }

    private void searchCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("categoryName");
        List<Category> categoryResult = categoryService.findByCategoryName(categoryName);
        req.setAttribute("categories", categoryResult);
        req.getRequestDispatcher("/WEB-INF/views/categories/list.jsp").forward(req, resp);
    }
}
