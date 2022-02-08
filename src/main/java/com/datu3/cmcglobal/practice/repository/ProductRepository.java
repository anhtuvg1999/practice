package com.datu3.cmcglobal.practice.repository;

import com.datu3.cmcglobal.practice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findProductByCode(String code);
}
