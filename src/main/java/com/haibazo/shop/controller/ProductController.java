package com.haibazo.shop.controller;

import com.haibazo.shop.dto.request.ProductRequest;
import com.haibazo.shop.dto.response.ApiResponse;
import com.haibazo.shop.dto.response.PageResponse;
import com.haibazo.shop.dto.response.ProductResponse;
import com.haibazo.shop.server.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final String DEFAULT_PRICE_FROM = "0.0";
    private final String DEFAULT_PRICE_T0 = "9999.0";

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/create")
    public ApiResponse<ProductResponse> createProduct (@RequestParam("image") MultipartFile file, @ModelAttribute ProductRequest productRequest) throws IOException {
        return ApiResponse.<ProductResponse>builder()
                .result(productService.createProduct(productRequest, file))
                .build();
    }

    @GetMapping("/search")
    public ApiResponse<List<ProductResponse>> searchProduct (
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String categoryName,
            @RequestParam(required = false) String colorName,
            @RequestParam(required = false) String sizeLabel,
            @RequestParam(required = false) String styleName,
            @RequestParam(required = false, defaultValue = DEFAULT_PRICE_FROM) float priceFrom,  // Tham số tùy chọn
            @RequestParam(required = false, defaultValue = DEFAULT_PRICE_T0) float priceTo
    ){
        return ApiResponse.<List<ProductResponse>>builder()
                .result(productService.searchProduct(keyword, categoryName, colorName, sizeLabel,styleName, priceFrom, priceTo))
                .build();
    }

    @GetMapping
    public ApiResponse<PageResponse<ProductResponse>> getAllProduct(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value ="size", required = false, defaultValue = "10") int size
    ){
        return ApiResponse.<PageResponse<ProductResponse>>builder()
                .result(productService.getAllProduct(page,size))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<ProductResponse> updateProduct (@PathVariable Long id, @RequestParam(value = "image",required = false) MultipartFile file, @ModelAttribute ProductRequest productRequest) throws IOException {
        return ApiResponse.<ProductResponse>builder()
                .result(productService.updateProduct(id,productRequest, file))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteProduct (@PathVariable Long id){
        productService.deleteProduct(id);
        return ApiResponse.<Void>builder().build();
    }
}
