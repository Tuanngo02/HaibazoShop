package com.haibazo.shop.repository;

import com.haibazo.shop.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {
}
