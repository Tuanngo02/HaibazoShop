package com.haibazo.shop.mapper;

import com.haibazo.shop.dto.request.ProductRequest;
import com.haibazo.shop.dto.response.ProductResponse;
import com.haibazo.shop.entity.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class ProductMapper {
    public Product toProduct (ProductRequest productRequest, Category category, Color color, Size size, Style style, String image_url) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setOriginal_price(productRequest.getOriginal_price());
        product.setImage_url(image_url);
        product.setRating(productRequest.getRating());
        product.setCategory(category);
        product.setColor(color);
        product.setSize(size);
        product.setStyle(style);
        return product;
    }

    public ProductResponse toProductResponse(Product product){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        productResponse.setOriginal_price(product.getOriginal_price());
        productResponse.setImage_url(product.getImage_url());
        productResponse.setRating(product.getRating());
        productResponse.setCategory(product.getCategory().getName());
        productResponse.setColor(product.getColor().getName());
        productResponse.setSize(product.getSize().getLabel());
        productResponse.setStyle(product.getStyle().getName());
        return productResponse;
    }

    public Product updateProduct (Product product, ProductRequest productRequest, Category category, Color color, Size size, Style style, String image_url){
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setOriginal_price(productRequest.getOriginal_price());
        product.setImage_url(image_url);
        product.setRating(productRequest.getRating());
        product.setCategory(category);
        product.setColor(color);
        product.setSize(size);
        product.setStyle(style);
        return product;
    }
}
