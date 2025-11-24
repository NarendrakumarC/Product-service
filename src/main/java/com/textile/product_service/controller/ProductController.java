package com.textile.product_service.controller;

import com.textile.product_service.dtos.FakeStoreProductDTO;
import com.textile.product_service.exception.ProductNotFoundException;
import com.textile.product_service.models.Product;
import com.textile.product_service.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/products") // Base URL for product-related endpoints
public class ProductController {

    private ProductService selfProductService;
    //private ProductService fakeProductService;

    // Constructor Injection for Junit testing
    public ProductController(@Qualifier("selfProductService") ProductService selfProductService) {
        this.selfProductService = selfProductService;
    }



    /* public ProductController
            (@Qualifier("selfProductService") ProductService selfProductService,
            @Qualifier("fakeStoreProductService") ProductService fakeProductService)
    {
        this.selfProductService = selfProductService;
        this.fakeProductService = fakeProductService;
    }*/

/*
    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId") Long productId) throws ProductNotFoundException {
        // Logic to retrieve a single product by ID
        // This is a placeholder; actual implementation will involve fetching from a database or service
        // https://fakestoreapi.com/products/2
        return fakeProductService.getSingleProduct(productId);
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        // Logic to retrieve all products
        // This is a placeholder; actual implementation will involve fetching from a database or service
       */
/* return List.of(
            new Product("1", "Product 1", "Description for product 1", 19.99, "http://example.com/image1.jpg", new Category("1", "Category 1", "Description for category 1")),
            new Product("2", "Product 2", "Description for product 2", 29.99, "http://example.com/image2.jpg", new Category("2", "Category 2", "Description for category 2"))
        );*//*


        return fakeProductService.getAllProducts();
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody FakeStoreProductDTO product) {
        // Logic to create a new product
        // This is a placeholder; actual implementation will involve saving to a database or service
        return fakeProductService.createProduct(product);
    }

    @PutMapping("/update/{productId}")
    public Product replaceProduct(@PathVariable("productId") Long productId, @RequestBody FakeStoreProductDTO product) throws ProductNotFoundException {
        // Logic to replace an existing product
        // This is a placeholder; actual implementation will involve updating in a database or service
      return fakeProductService.replaceProduct(productId, product);
    }

    @DeleteMapping("/delete/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        // Logic to delete a product by ID
        // This is a placeholder; actual implementation will involve deleting from a database or service
        fakeProductService.deleteProduct(productId);
    }
*/

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException ex) {
        return new ResponseEntity<>(
                ex.getProductId() + "is Invalid Product Id. Please try again with valid product Id " +
                        "and priority hirearchy is given from class level to global handler level"
                +"Priority Order : Controller Level (try catch) > Controller Class(Local) level > Global Handler Level",
                HttpStatus.NOT_FOUND);
    }

    @GetMapping("/self/{productId}")
    public Product getSingleSelfProduct(@PathVariable("productId") Long productId) throws ProductNotFoundException {
        // Logic to retrieve a single product by ID
        // This is a placeholder; actual implementation will involve fetching from a database or service
        System.out.println("Debug for testing controller req from test method");

        //return selfProductService.getSingleProduct(productId);
        //return new Product();
        Product product = selfProductService.getSingleProduct(productId); //@16640 same mock object for testing

        // Case1 : Both acutal and expected are pointing to same object address in heap memory hence test is passed
        // product.setTitle("IPhone 14 Pro Max");

        // Case2 : Both actual and expected are different object address in heap memory but having same values , test is failed
       /* Product expectedProduct = new Product(); //@15540
        expectedProduct.setId(productId);
        expectedProduct.setTitle("IPhone 14 Pro Max");
        expectedProduct.setDescription("Latest Apple iPhone 14 Pro with advanced features");
        expectedProduct.setPrice(130000.00);*/

        return product;
    }

    @GetMapping("/self")
    public List<Product> getAllSelfProducts() {
        // Logic to retrieve all products
        return selfProductService.getAllProducts();
    }

    @PostMapping("/self/create")
    public Product createSelfProduct(@RequestBody FakeStoreProductDTO product) {
        // Logic to create a new product
        return selfProductService.createProduct(product);
    }

    @PutMapping("/self/update/{productId}")
    public Product replaceSelfProduct(@PathVariable("productId") Long productId, @RequestBody FakeStoreProductDTO product) throws ProductNotFoundException {
        // Logic to replace an existing product
        return selfProductService.replaceProduct(productId, product);
    }

    @DeleteMapping("/self/delete/{productId}")
    public void deleteSelfProduct(@PathVariable("productId") Long productId) {
        // Logic to delete a product by ID
        selfProductService.deleteProduct(productId);
    }


}
