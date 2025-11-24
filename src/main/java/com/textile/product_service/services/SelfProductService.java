package com.textile.product_service.services;

import com.textile.product_service.dtos.FakeStoreProductDTO;
import com.textile.product_service.exception.ProductNotFoundException;
import com.textile.product_service.models.Category;
import com.textile.product_service.models.Product;
import com.textile.product_service.repo.CategoryRepository;
import com.textile.product_service.repo.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
@Primary
public class SelfProductService implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
       Optional<Product> product= productRepository.findById(productId);
            if(product.isEmpty()){
                throw new ProductNotFoundException(productId);
            }
        return product.get();
    }

    @Override
    public Product createProduct(FakeStoreProductDTO product) {
        Product newProduct = new Product();
        newProduct.setTitle(product.getTitle());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setImageUrl(product.getImage());
        Optional<Category> existingCategory = categoryRepository.findByName(product.getCategory());
        if(existingCategory.isEmpty()){
            // Create a new category
            Category category = new Category();
            category.setName(product.getCategory());
             Category savedCategory =   categoryRepository.save(category);
             newProduct.setCategory(savedCategory);
        }
       /* Category category = new Category();
        category.setName(product.getCategory());
        newProduct.setCategory(category);*/
        return productRepository.save(newProduct);
    }

    @Override
    public Product replaceProduct(Long productId, FakeStoreProductDTO fakeStoreProductDTO) throws ProductNotFoundException {
        Optional<Product> existingProduct = productRepository.findById(productId);
        if (existingProduct.isPresent()) {
            Product productToUpdate = existingProduct.get();
            productToUpdate.setTitle(fakeStoreProductDTO.getTitle());
            productToUpdate.setDescription(fakeStoreProductDTO.getDescription());
            productToUpdate.setPrice(fakeStoreProductDTO.getPrice());
            productToUpdate.setImageUrl(fakeStoreProductDTO.getImage());
            // Update other fields as necessary
            return productRepository.save(productToUpdate);
        }else {
            throw new ProductNotFoundException(productId);
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
