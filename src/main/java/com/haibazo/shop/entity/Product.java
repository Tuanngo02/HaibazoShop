package com.haibazo.shop.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "dbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float price;
    private float original_price;
    private String image_url;
    private String rating;
    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "product_color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "product_size_id")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "product_style_id")
    private Style style;
}
