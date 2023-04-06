package com.apps.blog.services;

import com.apps.blog.payloads.CategoryDto;
import com.apps.blog.payloads.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    void deleteCategory(Integer categoryId);
    CategoryDto getCategoryById(Integer categoryId);
    CategoryResponse getAllCategory(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

}
