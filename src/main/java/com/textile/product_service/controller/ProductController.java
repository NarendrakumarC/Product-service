package com.textile.product_service.controller;

import com.textile.product_service.models.Product;
import com.textile.product_service.services.ProductService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/products") // Base URL for product-related endpoints
public class ProductController {

    private ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId") Long productId) {
        // Logic to retrieve a single product by ID
        // This is a placeholder; actual implementation will involve fetching from a database or service
        // https://fakestoreapi.com/products/2
        return productService.getSingleProduct(productId);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        // Logic to retrieve all products
        // This is a placeholder; actual implementation will involve fetching from a database or service
       /* return List.of(
            new Product("1", "Product 1", "Description for product 1", 19.99, "http://example.com/image1.jpg", new Category("1", "Category 1", "Description for category 1")),
            new Product("2", "Product 2", "Description for product 2", 29.99, "http://example.com/image2.jpg", new Category("2", "Category 2", "Description for category 2"))
        );*/
        return null;
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        // Logic to create a new product
        // This is a placeholder; actual implementation will involve saving to a database or service
        return product;
    }

    @PatchMapping("/{productId}")
    public void replaceProduct(@PathVariable("productId") Long productId, @RequestBody Product product) {
        // Logic to replace an existing product
        // This is a placeholder; actual implementation will involve updating in a database or service
    }

    @PutMapping("")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        // Logic to delete a product by ID
        // This is a placeholder; actual implementation will involve deleting from a database or service

    }

}
