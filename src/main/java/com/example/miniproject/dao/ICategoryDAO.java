package com.example.miniproject.dao;

import com.example.miniproject.entity.Category;

import java.util.List;

public interface ICategoryDAO {
    List<Category> findAll();
    Category findById(Integer id);
    boolean addCategory(Category category);
    boolean updateCategory(Category category);
    boolean deleteCategory(Integer id);
    List<Category> findByCategoryName(String categoryName);
}
