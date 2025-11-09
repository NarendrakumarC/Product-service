package com.textile.product_service;

import com.textile.product_service.models.Product;
import com.textile.product_service.projections.ProductWithTitleAndPrice;
import com.textile.product_service.repo.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testProjectionQuery(){
		List<ProductWithTitleAndPrice> productWithTitleAndPrices = productRepository.findTitleAndPriceById();
		for(ProductWithTitleAndPrice p: productWithTitleAndPrices) {
			System.out.println("Title: " + p.getTitle() + " Price: " + p.getPrice());
		}

		Optional<Product> product = productRepository.findByCategory_Name("Electronics");
		System.out.println(product.get().getPrice());

	}
}
