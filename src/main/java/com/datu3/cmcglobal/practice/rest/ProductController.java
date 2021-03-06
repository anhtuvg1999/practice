package com.datu3.cmcglobal.practice.rest;

import com.datu3.cmcglobal.practice.exeption.CustomException;
import com.datu3.cmcglobal.practice.model.Product;
import com.datu3.cmcglobal.practice.request.ProductRequest;
import com.datu3.cmcglobal.practice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@PropertySource("classpath:application.properties")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/api/products")
    public ResponseEntity<Page<Product>> getAllProduct(Integer page, Integer size){
        if(page < 1) {
            throw new CustomException("Page must be greater by 1", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Product> listProduct = productService.getAllProduct(pageable);
        return new ResponseEntity<>(listProduct, HttpStatus.OK);
    }

    @GetMapping(value = "/api/products/{code}")
    public ResponseEntity<Product> getProduct(@PathVariable("code") String code){
        Product product = productService.getProduct(code+" ");
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping(value = "/api/products")
    public ResponseEntity<Void> createProduct(@RequestBody ProductRequest request) {
        productService.createProduct(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/products/{code}")
    public ResponseEntity<Void> updateProduct(@RequestBody ProductRequest request,@PathVariable("code") String code) {
        productService.updateProduct(request,code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/products/{code}")
    public ResponseEntity<Void> delete(@PathVariable("code") String code) {
        productService.deleteProduct(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
