package com.ecommerce.sb_ecom.controller;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories =
                categoryService.getAllCategories();

        return ResponseEntity.ok(categories);
    }

    @PostMapping("/public/categories")
    public ResponseEntity<String> createCategory(
            @RequestBody Category category) {

        categoryService.createCategory(category);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Category added successfully");
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(
            @PathVariable Long categoryId) {

        String status =
                categoryService.deleteCategory(categoryId);

        return ResponseEntity.ok(status);
    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<Category> updateCategory(
            @RequestBody Category category,
            @PathVariable Long categoryId) {

        Category updatedCategory =
                categoryService.updateCategory(category, categoryId);

        return ResponseEntity.ok(updatedCategory);
    }

    @GetMapping("/public/categories/{categoryId}")
    public ResponseEntity<Category> getCategoryById(
            @PathVariable Long categoryId) {

        Category category =
                categoryService.getCategoryById(categoryId);

        if (category == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(category);
    }
}
