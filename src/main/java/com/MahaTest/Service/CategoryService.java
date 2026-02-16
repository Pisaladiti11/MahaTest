package com.MahaTest.Service;


import com.MahaTest.Entity.Category;

import java.util.List;

public interface CategoryService {

    Category saveCategory(Category category);

    Category updateCategory(Long id, Category category);

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    void deleteCategory(Long id);
}

