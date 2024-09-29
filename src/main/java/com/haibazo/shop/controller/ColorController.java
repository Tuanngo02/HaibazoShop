package com.haibazo.shop.controller;

import com.haibazo.shop.dto.request.ColorRequest;
import com.haibazo.shop.dto.response.ApiResponse;
import com.haibazo.shop.dto.response.ColorResponse;
import com.haibazo.shop.server.impl.ColorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/color")
public class ColorController {
    @Autowired
    private ColorServiceImpl colorService;

    @PostMapping("/create")
    ApiResponse<ColorResponse> createColor(@RequestBody ColorRequest request) {
        return ApiResponse.<ColorResponse>builder()
                .result(colorService.createColor(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<ColorResponse>> getAllColor() {
        return ApiResponse.<List<ColorResponse>>builder()
                .result(colorService.getAllColor())
                .build();
    }

    @PutMapping("/{id}")
    ApiResponse<ColorResponse> updateColor(@PathVariable Long id, @RequestBody ColorRequest request) {
        return ApiResponse.<ColorResponse>builder()
                .result(colorService.updateColor(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteColor(@PathVariable Long id) {
        colorService.deleteColor(id);
        return ApiResponse.<Void>builder().build();
    }
}
