package com.textile.product_service.services;

import com.textile.product_service.dtos.FakeStoreProductDTO;
import com.textile.product_service.exception.ProductNotFoundException;
import com.textile.product_service.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getSingleProduct(Long productId) throws ProductNotFoundException;
    Product createProduct(FakeStoreProductDTO product);
    Product replaceProduct(Long productId, FakeStoreProductDTO fakeStoreProductDTO) throws ProductNotFoundException;
    void deleteProduct(Long productId);

}
