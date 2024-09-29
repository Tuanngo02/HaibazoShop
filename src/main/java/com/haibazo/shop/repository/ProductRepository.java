package com.haibazo.shop.repository;

import com.haibazo.shop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);
    @Query("SELECT p FROM Product p WHERE (:keyword IS NULL OR p.name LIKE %:keyword%) " +
            "AND (:categoryName IS NULL OR p.category.name LIKE %:categoryName%) " +
            "AND (:colorName IS NULL OR p.color.name LIKE %:colorName%) " +
            "AND (:sizeLabel IS NULL OR p.size.label LIKE %:sizeLabel%) " +
            "AND (:styleName IS NULL OR p.style.name LIKE %:styleName%) " +
            "AND (:priceFrom IS NULL OR p.price >= :priceFrom) " +
            "AND (:priceTo IS NULL OR p.price <= :priceTo) ")
    List<Product> findByKeyword(
            @Param("keyword") String keyword,
            @Param("categoryName") String categoryName,
            @Param("colorName") String colorName,
            @Param("sizeLabel") String sizeLabel,
            @Param("styleName") String styleName,
            @Param("priceFrom") float priceFrom,
            @Param("priceTo") float priceTo
    );
    Page<Product> findAll(Pageable pageable);
}
