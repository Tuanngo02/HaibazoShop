package com.haibazo.shop.server;

import com.haibazo.shop.dto.request.ProductRequest;
import com.haibazo.shop.dto.response.PageResponse;
import com.haibazo.shop.dto.response.ProductResponse;
import com.haibazo.shop.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    ProductResponse createProduct  (ProductRequest productRequest, MultipartFile file) throws IOException;
    List<ProductResponse> searchProduct(String keyword, String categoryName, String colorName, String sizeLabel, String styleName, float priceFrom, float priceTo);
    PageResponse<ProductResponse> getAllProduct (int page, int size);
    ProductResponse updateProduct (Long id, ProductRequest productRequest, MultipartFile file) throws IOException;
    void deleteProduct (Long id);
}
