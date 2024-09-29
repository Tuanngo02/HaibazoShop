package com.haibazo.shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "dbl_style")
public class Style {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "style", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true,targetEntity = Product.class)
    List<Product> products;
}
