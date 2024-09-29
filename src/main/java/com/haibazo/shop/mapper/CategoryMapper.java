package com.haibazo.shop.mapper;

import com.haibazo.shop.dto.request.CategoryRequest;
import com.haibazo.shop.dto.response.CategoryResponse;
import com.haibazo.shop.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryRequest request);

    CategoryResponse toCategoryResponse(Category category);

    void updateCategory(@MappingTarget Category category, CategoryRequest categoryRequest);
}
