package com.springboot.blog.controller;

import com.springboot.blog.dto.CategoryDto;
import com.springboot.blog.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto savedCategory = categoryService.addCategory(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable("id") Long categoryId){
        CategoryDto categoryDto = categoryService.getCategory(categoryId);
        return ResponseEntity.ok(categoryDto);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable("id") Long categoryId) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryDto, categoryId));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted successfully");
    }
}