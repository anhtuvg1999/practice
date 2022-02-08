package com.datu3.cmcglobal.practice.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String code;
    private String name;
    private String category;
    private String brand;
    private String type;
    private String description;

    public ProductRequest() {
    }

    public ProductRequest(String code, String name, String category, String brand, String type, String description) {
        this.code = code;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.type = type;
        this.description = description;
    }
}
