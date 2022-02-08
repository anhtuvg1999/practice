package com.datu3.cmcglobal.practice.service;

import com.datu3.cmcglobal.practice.model.Product;
import com.datu3.cmcglobal.practice.request.ProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> getAllProduct(Pageable pageable);

    Product getProduct(String code);

    void createProduct(ProductRequest request);

    void updateProduct(ProductRequest request, String code);

    void deleteProduct(String code);
}
