package com.datu3.cmcglobal.practice.service.impl;

import com.datu3.cmcglobal.practice.model.Product;
import com.datu3.cmcglobal.practice.repository.ProductRepository;
import com.datu3.cmcglobal.practice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product getProduct(String code) {
        return productRepository.findProductByCode(code);
    }
}
