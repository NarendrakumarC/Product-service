package com.textile.product_service.services;

import com.textile.product_service.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getSingleProduct(Long productId);
    Product createProduct(Product product);
    Product replaceProduct(Long productId, Product product);
    void deleteProduct(Long productId);

}
