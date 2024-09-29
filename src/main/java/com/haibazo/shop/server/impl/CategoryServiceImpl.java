package com.haibazo.shop.server.impl;

import com.haibazo.shop.dto.request.CategoryRequest;
import com.haibazo.shop.dto.response.CategoryResponse;
import com.haibazo.shop.entity.Category;
import com.haibazo.shop.mapper.CategoryMapper;
import com.haibazo.shop.repository.CategoryRepository;
import com.haibazo.shop.server.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        Category category = categoryMapper.toCategory(categoryRequest);

        categoryRepository.save(category);

        return categoryMapper.toCategoryResponse(category);
    }

    @Override
    public List<CategoryResponse> getAllCategory() {
        return categoryRepository.findAll().stream().map(categoryMapper::toCategoryResponse).toList();
    }

    @Override
    public CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("không tìm thấy"));

        categoryMapper.updateCategory(category, categoryRequest);

        categoryRepository.save(category);

        return categoryMapper.toCategoryResponse(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
