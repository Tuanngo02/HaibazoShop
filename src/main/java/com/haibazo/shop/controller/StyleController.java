package com.haibazo.shop.controller;

import com.haibazo.shop.dto.request.StyleRequest;
import com.haibazo.shop.dto.response.ApiResponse;
import com.haibazo.shop.dto.response.StyleResponse;
import com.haibazo.shop.server.impl.StyleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/style")
public class StyleController {
    @Autowired
    private StyleServiceImpl styleService;

    @PostMapping("/create")
    ApiResponse<StyleResponse> createCategory(@RequestBody StyleRequest request) {
        return ApiResponse.<StyleResponse>builder()
                .result(styleService.createStyle(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<StyleResponse>> getAllCategory() {
        return ApiResponse.<List<StyleResponse>>builder()
                .result(styleService.getAllStyle())
                .build();
    }

    @PutMapping("/{id}")
    ApiResponse<StyleResponse> updateCategory(@PathVariable Long id, @RequestBody StyleRequest request) {
        return ApiResponse.<StyleResponse>builder()
                .result(styleService.updateStyle(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteCategory(@PathVariable Long id) {
        styleService.deleteStyle(id);
        return ApiResponse.<Void>builder().build();
    }
}
