package com.textile.product_service.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseModel {
    public Category(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    private String name;
    private String description;


}
