package com.apps.blog.controllers;

import com.apps.blog.payloads.ApiResponse;
import com.apps.blog.payloads.CategoryDto;
import com.apps.blog.payloads.CategoryResponse;
import com.apps.blog.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createCategoryDto = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createCategoryDto, HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable("categoryId") Integer catId){
        CategoryDto updateCategoryDto = this.categoryService.updateCategory(categoryDto, catId);
        return ResponseEntity.ok(updateCategoryDto);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") Integer catId){
        this.categoryService.deleteCategory(catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully!!", true, 200), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<CategoryResponse> getAllCategory(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "2", required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = "categoryId", required = false) String sortBy,
            @RequestParam(value = "sortOrder", defaultValue = "asc", required = false) String sortOrder
    ){
        return ResponseEntity.ok(this.categoryService.getAllCategory(pageNumber, pageSize, sortBy, sortOrder));
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable("categoryId") Integer catId){
        return ResponseEntity.ok(this.categoryService.getCategoryById(catId));
    }
}
