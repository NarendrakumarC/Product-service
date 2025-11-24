package com.textile.product_service.controller;

import com.textile.product_service.exception.ProductNotFoundException;
import com.textile.product_service.models.Product;
import com.textile.product_service.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
//Arranged the objects
    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @Test
    public void testGetSingleProductPositive() throws ProductNotFoundException {
        //Arrange the input parameters
        Long productId = 10L;
        //Act upon the data or fun call
        //    try {
            Product expectedProduct = new Product(); //@16640
            expectedProduct.setId(productId);
            expectedProduct.setTitle("IPhone 14 Pro");
            expectedProduct.setDescription("Latest Apple iPhone 14 Pro with advanced features");
            expectedProduct.setPrice(130000.00);
            when(productService.getSingleProduct(productId))
                    .thenReturn(expectedProduct);
            Product actualProduct = productController.getSingleSelfProduct(productId); //@16640
            System.out.println(expectedProduct.getTitle());
            System.out.println(actualProduct.getTitle());
        //Assert the results
        // assertEquals will compare the reference address of both objects in heap memory if equals then only test case will be passed
      //      assertEquals(expectedProduct, actualProduct, "The returned product should match the expected product");
       assertEquals(expectedProduct.getId(), actualProduct.getId(), "Product ID should match");
        // If first assertion is passed then only next assertions will be executed
         assertEquals(expectedProduct.getTitle(), actualProduct.getTitle(), "Product Title should match");
         assertEquals(expectedProduct.getDescription(), actualProduct.getDescription(), "Product Description should match");
            assertEquals(expectedProduct.getPrice(), actualProduct.getPrice(), "Product Price should match");



          /*  Product product = productController.getSingleProduct(productId);
            assertNotNull(product, "Product should not be null");
            assertEquals(productId, product.getId(), "Product ID should match the requested ID");
        } catch (Exception e) {
            fail("Exception should not be thrown for valid product ID");
        }*/
    }

    @Test
    void testGetSingleProductInvalidId() throws ProductNotFoundException {
        Long productId = -1L;
        when(productService.getSingleProduct(productId))
                .thenThrow(new ProductNotFoundException(productId));
        // Test will pass
       /* assertThrows(
                ProductNotFoundException.class,
                () -> productController.getSingleSelfProduct(productId));*/
        // Test will fail if expected is ProductNotFoundException but actual is NullPointerException
        assertThrows(
                NullPointerException.class,
                () ->productController.getSingleSelfProduct(productId));
    }

    @Test
    public void testGetSingleProductTimeout() throws ProductNotFoundException {
        // This method can be implemented to test timeout scenarios using Mockito's timeout feature
        Long productId = 5L;
        when(productService.getSingleProduct(productId))
                .thenAnswer(invocation -> {
                    Thread.sleep(2000); // Simulate delay
                    return new Product();
                });
        Product result = assertTimeout(Duration.ofSeconds(3),
                () -> productController.getSingleSelfProduct(productId));

        assertNotNull(result, "Returned product should not be null");
    }

    @Test
    public void testGetAllProducts() {
        // Implement test for getAllProducts method
     Product product1 = new Product();
     product1.setId(1L);
     product1.setTitle("Product 1");
     product1.setPrice(100.0);

     Product product2 = new Product();
        product2.setId(2L);
        product2.setTitle("Product 2");
        product2.setPrice(200.0);

     Product product3 = new Product();
        product3.setId(3L);
        product3.setTitle("Product 3");
        product3.setPrice(300.0);

        List<Product> expectedProducts = java.util.Arrays.asList(product1, product2, product3);

        when(productService.getAllProducts())
                .thenReturn(expectedProducts);

        java.util.List<Product> actualProducts = productController.getAllSelfProducts();

        assertNotNull(actualProducts, "Product list should not be null");
        // Testcase will pass
        assertEquals(3, actualProducts.size(), "Product list size should match the expected size");
        // Testcase will fail because expectedProducts has 3 products but actualProducts has 5 products
    //    assertEquals(5, actualProducts.size(), "Product list size should match the expected size");
        assertArrayEquals(expectedProducts.toArray(), actualProducts.toArray(), "Product lists should match");
    }

}