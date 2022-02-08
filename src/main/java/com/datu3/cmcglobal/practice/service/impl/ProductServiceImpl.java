package com.datu3.cmcglobal.practice.service.impl;

import com.datu3.cmcglobal.practice.exeption.CustomException;
import com.datu3.cmcglobal.practice.model.Product;
import com.datu3.cmcglobal.practice.repository.ProductRepository;
import com.datu3.cmcglobal.practice.request.ProductRequest;
import com.datu3.cmcglobal.practice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Properties;

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

    @Override
    public void createProduct(ProductRequest request) {
        Product product = new Product();
        product.setCode(request.getCode());
        product.setName(request.getName());
        product.setCategory(request.getCategory());
        product.setBrand(request.getBrand());
        product.setType(request.getType());
        product.setDescription(request.getDescription());
        productRepository.save(product);
    }

    @Override
    public void updateProduct(ProductRequest request, String code) {
        if(code == null){
            throw new CustomException("This product does not exist!", HttpStatus.FORBIDDEN.value());
        }
        Product product = productRepository.findProductByCode(code);
        if(product == null){
            throw new CustomException("Not found product!", HttpStatus.NOT_FOUND.value());
        }
        if(request.getName() != null)
        product.setName(request.getName());
        if(request.getCategory() != null)
        product.setCategory(request.getCategory());
        if(request.getBrand() != null)
        product.setBrand(request.getBrand());
        if(request.getType() != null)
        product.setType(request.getType());
        if(request.getDescription() != null)
        product.setDescription(request.getDescription());
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(String code) {
        if(code == null){
            throw new CustomException("This product does not exist!", HttpStatus.FORBIDDEN.value());
        }
        Product product = productRepository.findProductByCode(code);
        if(product == null){
            throw new CustomException("Not found product!", HttpStatus.NOT_FOUND.value());
        }
        productRepository.delete(product);
    }
}
