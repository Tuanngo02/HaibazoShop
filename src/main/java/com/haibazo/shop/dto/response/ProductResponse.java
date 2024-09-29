package com.haibazo.shop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private String name;
    private float price;
    private float original_price;
    private String image_url;
    private String rating;
    private String category;
    private String color;
    private String size;
    private String style;
}
