package com.apps.blog.services.impl;

import com.apps.blog.entities.Category;
import com.apps.blog.exceptions.ResourceNotFoundException;
import com.apps.blog.payloads.CategoryDto;
import com.apps.blog.payloads.CategoryResponse;
import com.apps.blog.repositories.CategoryRepo;
import com.apps.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.dtoToCategory(categoryDto);
        Category saveCategory = this.categoryRepo.save(category);
        return this.categoryToDto(saveCategory);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        Category updateSave = this.categoryRepo.save(category);
        CategoryDto categoryDto1 = this.categoryToDto(updateSave);
        return categoryDto1;
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "id", categoryId));
        this.categoryRepo.delete(category);
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "id", categoryId));
        return this.categoryToDto(category);
    }

    @Override
    public CategoryResponse getAllCategory(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

        Sort sort = (sortOrder.equalsIgnoreCase("asc"))? (Sort.by(sortBy).ascending()):(Sort.by(sortBy).descending());
        Pageable p = PageRequest.of(pageNumber, pageSize, sort);
        Page<Category> categoryPage = this.categoryRepo.findAll(p);
        List<Category> allCategories = categoryPage.getContent();
        List<CategoryDto> categoryDtos = allCategories.stream().map(category -> this.categoryToDto(category)).collect(Collectors.toList());

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDtos);
        categoryResponse.setPageNumber(categoryPage.getNumber());
        categoryResponse.setPageSize(categoryPage.getSize());
        categoryResponse.setSortBy(sortBy);
        categoryResponse.setSortOrder(sortOrder);
        categoryResponse.setTotalElements(categoryPage.getTotalElements());
        categoryResponse.setTotalPages(categoryPage.getTotalPages());
        categoryResponse.setFirstPage(categoryPage.isFirst());
        categoryResponse.setLastPage(categoryPage.isLast());

        return categoryResponse;

    }

    public Category dtoToCategory(CategoryDto categoryDto){
        Category category = this.modelMapper.map(categoryDto, Category.class);
        return category;
    }

    public CategoryDto categoryToDto(Category category){
        CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }
}
