package com.example.miniproject.dao.impl;

import com.example.miniproject.dao.ICategoryDAO;
import com.example.miniproject.entity.Category;
import com.example.miniproject.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements ICategoryDAO {
    @Override
    public List<Category> findAll() {
        Connection con = ConnectionDB.openConnection();
        List<Category> categoryList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("Select * from category");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setStatus(rs.getBoolean("status"));
                categoryList.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(con);
        }
        return categoryList;
    }

    @Override
    public Category findById(Integer id) {
        Connection con = ConnectionDB.openConnection();

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("select * from category where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setStatus(rs.getBoolean("status"));
                return category;
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
    public boolean addCategory(Category category) {
        Connection con = ConnectionDB.openConnection();
        try {
            PreparedStatement ps = con.prepareStatement("insert into category (name, status) value (?, ?)");
            ps.setString(1, category.getName());
            ps.setBoolean(2, category.isStatus());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(con);
        }
    }

    @Override
    public boolean updateCategory(Category category) {
        Connection con = ConnectionDB.openConnection();

        try {
            PreparedStatement ps = con.prepareStatement("update category set name = ?, status = ? where id = ?");
            ps.setString(1, category.getName());
            ps.setBoolean(2, category.isStatus());
            ps.setInt(3, category.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(con);
        }

    }

    @Override
    public boolean deleteCategory(Integer id) {
       Connection con = ConnectionDB.openConnection();

        try {
            PreparedStatement ps = con.prepareStatement("delete from category where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(con);
        }

    }

    @Override
    public List<Category> findByCategoryName(String categoryName) {
        List<Category> categoryList = new ArrayList<>();
        Connection con = ConnectionDB.openConnection();
        try {
            if (categoryName == null || categoryName.isEmpty()) {
                categoryName = "%";
            }
            else {
                categoryName = "%" + categoryName + "%";
            }
            PreparedStatement ps = con.prepareStatement("select * from category where name like ?");
            ps.setString(1, "%" + categoryName + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setStatus(rs.getBoolean("status"));
                categoryList.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(con);
        }
        return categoryList;


    }
}
