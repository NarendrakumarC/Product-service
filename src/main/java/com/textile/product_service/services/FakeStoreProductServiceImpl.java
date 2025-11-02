package com.textile.product_service.services;

import com.textile.product_service.dtos.FakeStoreProductDTO;
import com.textile.product_service.exception.ProductNotFoundException;
import com.textile.product_service.models.Category;
import com.textile.product_service.models.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
        ResponseEntity<FakeStoreProductDTO[]> responseEntity =
                restTemplate.getForEntity("https://fakestoreapi.com/products",
                        FakeStoreProductDTO[].class);
        FakeStoreProductDTO[] fakeStoreProductDTOs = responseEntity.getBody();
        if (fakeStoreProductDTOs != null) {
            return List.of(fakeStoreProductDTOs).stream()
                    .map(this::convertFakeStoreProductDtoToProduct)
                    .toList();
        }
        return List.of();
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        // https://fakestoreapi.com/products/2
        ResponseEntity<FakeStoreProductDTO> responseEntity =
                restTemplate.getForEntity("https://fakestoreapi.com/products/" + productId,
                        FakeStoreProductDTO.class);
        FakeStoreProductDTO fakeStoreProductDTO = responseEntity.getBody();
        if(fakeStoreProductDTO == null){
            throw new ProductNotFoundException(productId);
        }

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDTO);
    }


    @Override
    public Product createProduct(FakeStoreProductDTO product) {
        ResponseEntity<FakeStoreProductDTO> responseEntity =
                restTemplate.postForEntity("https://fakestoreapi.com/products",
                        product, FakeStoreProductDTO.class);
        FakeStoreProductDTO fakeStoreProductDTO = responseEntity.getBody();
        if (fakeStoreProductDTO != null) {
            return convertFakeStoreProductDtoToProduct(fakeStoreProductDTO);
        }
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, FakeStoreProductDTO product) {
       String url = "https://fakestoreapi.com/products/" + productId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<FakeStoreProductDTO> requestEntity = new HttpEntity<>(product, headers);
        ResponseEntity<FakeStoreProductDTO> responseEntity =
                restTemplate.exchange(url, org.springframework.http.HttpMethod.PUT,
                        requestEntity, FakeStoreProductDTO.class);
        FakeStoreProductDTO fakeStoreProductDTO = responseEntity.getBody();
        if (fakeStoreProductDTO != null) {
            return convertFakeStoreProductDtoToProduct(fakeStoreProductDTO);
        }
        return null;
    }
        @Override
        public void deleteProduct (Long productId){
            restTemplate.delete("https://fakestoreapi.com/products/" + productId);
        }

    private Product convertFakeStoreProductDtoToProduct (FakeStoreProductDTO fakeStoreProductDto){
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





