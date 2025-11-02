package com.textile.product_service.services;

import com.textile.product_service.dtos.FakeStoreProductDTO;
import com.textile.product_service.models.Category;
import com.textile.product_service.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getSingleProduct(Long productId) {
        // https://fakestoreapi.com/products/2
    ResponseEntity<FakeStoreProductDTO> responseEntity =
            restTemplate.getForEntity("https://fakestoreapi.com/products/"+productId,
                    FakeStoreProductDTO.class);
        FakeStoreProductDTO fakeStoreProductDTO = responseEntity.getBody();
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDTO);
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDTO fakeStoreProductDto) {
        Product product = new Product();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getTitle());
        category.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(category);
        product.setId(fakeStoreProductDto.getId());
        return product;
    }
}
