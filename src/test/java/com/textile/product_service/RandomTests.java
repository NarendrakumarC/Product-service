package com.textile.product_service;

import com.textile.product_service.controller.ProductController;
import com.textile.product_service.exception.ProductNotFoundException;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class RandomTests {

    // Test Case - method which gets executed automatically at the time of build or deployment

    private ProductController productController;

    @Test
    public void sampleTestCase() {
        //Arrange
        int a = 10;
        int b = 20;

        //Act
        int result = a + b; // actual result

        //Assert
    //    assert result == 310 : "Addition result is incorrect"; // validating actual against expected
        assertEquals(30, result, "Addition result is incorrect");
       // assertNotEquals(31, result, "Addition result should not be 31");
        //assertNull(null, "Object should be null");
        //assertNotNull(result, "Object should not be null");
       /* assertThrows(ProductNotFoundException.class,
                () -> productController.getSingleProduct(-1)

        );*/

       /* assertTimeout(Duration.ofMillis(1000),
                () -> productController.getSingleProduct(10L));*/

    /*assertInstanceOf(
            Eagle.class,
            BirdFactory.getBirdForType(BirdType.EAGLE)
    );*/


        System.out.println("This is a sample test case");
    }

    /*
    *  3A's framework of testing
    * 1. Arrange - prepare the data(input params, mock objects, etc)
    * 2. Act - call the method
    * 3. Assert - verify the result(validate the actual against expected)
    *
    * */

}
