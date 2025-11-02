package com.textile.product_service.exception;

public class ProductNotFoundException extends Exception{
    private Long productId;
    public ProductNotFoundException(Long productId) {
        super("Product with ID " + productId + " not found.");
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
