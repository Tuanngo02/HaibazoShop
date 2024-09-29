package com.haibazo.shop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "dbl_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true,targetEntity = Product.class)
    @ToString.Exclude
    List<Product> products;
}
