package org.example.jpademo.controller;

import org.example.jpademo.entities.Product;
import org.example.jpademo.models.ProductCreatedRequest;
import org.example.jpademo.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/Product")
//@Controller()
public class HomeController {
    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/name")
    @ResponseBody()
    public List<String> home() {
        List<String> list = new ArrayList<>();
        list.add("Rohit");
        list.add("Marie");
        list.add("Alex");
        list.add("Bob");

        return list;
    }


    //get single product
    @RequestMapping("/{ProductId}")
    public Product getProductById(@PathVariable("ProductId") int ProductId) {
        return productService.getProductById(ProductId);

    }

    // get all product
    @RequestMapping("/all")
    public List<Product> getAllProduct() {
        List<Product> allProducts = productService.getAllProducts();
        return allProducts;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Product createProduct(@RequestBody ProductCreatedRequest productCreatedRequest) {
        System.out.println(productCreatedRequest);
        Product product = new Product();
        product.setisLive(true);
        product.setPrice(productCreatedRequest.getPrice());
        product.setTitle(productCreatedRequest.getTitle());
        product.setDescription(productCreatedRequest.getDescription());
        return productService.createProduct(product);

    }
}
