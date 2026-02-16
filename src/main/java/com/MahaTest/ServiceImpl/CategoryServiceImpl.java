package com.MahaTest.ServiceImpl;

import com.MahaTest.Entity.Category;
import com.MahaTest.Repository.CategoryRepository;
import com.MahaTest.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    //  Save Category
    @Override
    public Category saveCategory(Category category) {

        // Optional: Check duplicate name
        if (categoryRepository.existsByName(category.getName())) {
            throw new RuntimeException("Category already exists with name: " + category.getName());
        }

        return categoryRepository.save(category);
    }

    // Update Category
    @Override
    public Category updateCategory(Long id, Category category) {

        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        existingCategory.setActive(category.isActive());

        return categoryRepository.save(existingCategory);
    }

    // ✅ Get All Categories
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Get By id
    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }

    //  Delete Category
    @Override
    public void deleteCategory(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        categoryRepository.delete(category);
    }
}
