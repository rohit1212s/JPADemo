package org.example.jpademo.services;


import org.example.jpademo.entities.Product;
import org.example.jpademo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private  ProductRepository productRepository;

//    public ProductService() {
//    }

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
//        System.out.println(productRepository);
//        System.out.println(productRepository.getClass().getName());
    }

    // Create Product
    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

  // Find all
    public List<Product> getAllProducts() {
        List<Product> all = productRepository.findAll();
        return all;
    }

    // Find by id
    public Product getProductById(int productId) {
//        Product product = productRepository.findById(productId).get();
        return this.productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    //Delete product

    public void deleteProduct(int productId) {
        Product product = productRepository.findById(productId).get();
        productRepository.delete(product);
    }

}
