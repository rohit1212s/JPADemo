package org.example.jpademo;

import org.example.jpademo.entities.Product;
import org.example.jpademo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(JpaDemoApplication.class, args);
//        context.getBean()
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application starting");
//        Product product = new Product();
//        product.setDescription("This is better phone");
//        product.setPrice(1200);
//        product.setTitle("Iphone16");
//        product.setLive(true);
//        Product product1 = productService.createProduct(product);
//
//        System.out.println(product1);
//        System.out.println("Product created");

        productService.getAllProducts().forEach(System.out::println);
        Product productById = productService.getProductById(2);
        System.out.println(productById);

    }
}
