package com.ecommerce.productsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.productsearch.model.Product;
import com.ecommerce.productsearch.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        productRepository.save(product);
        return "Product added successfully";
    }

    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return productRepository.findByCategory(category);
    }

    @GetMapping("/filter")
    public List<Product> filterByPrice(@RequestParam double min,
                                       @RequestParam double max) {

        return productRepository.findByPriceBetween(min, max);
    }

    @GetMapping("/sorted")
    public List<Product> getSortedProducts() {
        return productRepository.findAllSortedByPrice();
    }

    @GetMapping("/expensive/{price}")
    public List<Product> expensiveProducts(@PathVariable double price) {
        return productRepository.findExpensiveProducts(price);
    }
}