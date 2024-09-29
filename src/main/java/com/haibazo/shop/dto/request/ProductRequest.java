package com.haibazo.shop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {
    private String name;
    private float price;
    private float original_price;
    private MultipartFile image;
    private String rating;
    private Long category;
    private Long color;
    private Long size;
    private Long style;
}
