package com.textile.product_service.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseModel {
    public BaseModel(String id) {
        this.id = id;
    }

    private String id;
    private String createdAt;
    private String updatedAt;

    // Additional common fields can be added here

}
