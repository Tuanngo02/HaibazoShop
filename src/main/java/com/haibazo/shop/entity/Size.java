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
@Table(name = "dbl_size")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    @OneToMany(mappedBy = "size", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true,targetEntity = Product.class)
    List<Product> products;
}
