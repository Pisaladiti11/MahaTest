package com.MahaTest.Controller;

import com.MahaTest.Entity.Category;
import com.MahaTest.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/categories")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CategoryController {

    private final CategoryService categoryService;

    // Create Category
    @PostMapping("/SaveCategory")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    //  Update Category
    @PutMapping("UpdateCategory/{id}")
    public Category updateCategory(@PathVariable Long id,
                                   @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    // Get All Categories
    @GetMapping("GetAllCategories/")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // Get Category By ID
    @GetMapping("GetCategoryById/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    // Delete Category
    @DeleteMapping("DeleteCategory/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "Category deleted successfully";
    }
}
