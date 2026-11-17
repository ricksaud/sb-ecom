package com.ecommerce.sb_ecom.controller;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.payload.CategoryDTO;
import com.ecommerce.sb_ecom.payload.CategoryResponse;
import com.ecommerce.sb_ecom.service.CategoryService;
import jakarta.validation.Valid;
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


    @GetMapping("/echo")
    public ResponseEntity<String> echoMessage(@RequestParam(name = "message") String message){
        return new ResponseEntity<>("Echoed message: " + message, HttpStatus.OK);
    }

    @GetMapping("/public/categories")
    public ResponseEntity<CategoryResponse> getAllCategories() {
        CategoryResponse categoryResponse =
                categoryService.getAllCategories();

        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    public ResponseEntity<CategoryDTO> createCategory(@Valid
            @RequestBody CategoryDTO categoryDTO) {

        CategoryDTO savedCategoryDTO = categoryService.createCategory(categoryDTO);

        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> deleteCategory(
            @PathVariable Long categoryId) {

        CategoryDTO deleteCategory =
                categoryService.deleteCategory(categoryId);

        return ResponseEntity.ok(deleteCategory);
    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(
            @RequestBody CategoryDTO categoryDTO,
            @PathVariable Long categoryId) {

        CategoryDTO updatedCategoryDTO =
                categoryService.updateCategory(categoryDTO, categoryId);

        return new ResponseEntity<>(updatedCategoryDTO, HttpStatus.OK);
    }


}
