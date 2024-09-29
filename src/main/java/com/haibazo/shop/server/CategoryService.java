package com.haibazo.shop.server;

import com.haibazo.shop.dto.request.CategoryRequest;
import com.haibazo.shop.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory (CategoryRequest categoryRequest);
    List<CategoryResponse> getAllCategory ();
    CategoryResponse updateCategory (Long id, CategoryRequest categoryRequest);
    void deleteCategory (Long id);
}
