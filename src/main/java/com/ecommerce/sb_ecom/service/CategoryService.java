package com.ecommerce.sb_ecom.service;


import com.ecommerce.sb_ecom.model.Category;

import java.util.List;

// For Loosing coupling and modularity
public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long categoryId);
    Category updateCategory(Category category, Long categoryId);
    Category getCategoryById(Long categoryId);
}
