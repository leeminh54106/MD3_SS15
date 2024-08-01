package com.example.miniproject.service.impl;

import com.example.miniproject.dao.ICategoryDAO;
import com.example.miniproject.dao.impl.CategoryDAOImpl;
import com.example.miniproject.entity.Category;
import com.example.miniproject.service.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {

    ICategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryDAO.findById(id);
    }

    @Override
    public boolean addCategory(Category category) {
        return categoryDAO.addCategory(category);
    }

    @Override
    public boolean updateCategory(Category category) {
        return categoryDAO.updateCategory(category);
    }

    @Override
    public boolean deleteCategory(Integer id) {
        return categoryDAO.deleteCategory(id);
    }

    @Override
    public List<Category> findByCategoryName(String categoryName) {
        return categoryDAO.findByCategoryName(categoryName);
    }
}
