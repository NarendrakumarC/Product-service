package com.textile.product_service.models;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Product extends BaseModel{

    public Product(String id, String title, String description, Double price, String imageUrl, Category category) {
        super(id);
        this.title = title;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private Category category;


}
