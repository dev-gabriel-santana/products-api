package com.example.produtosapi.controller;

import com.example.produtosapi.model.Product;
import com.example.produtosapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product store(@RequestBody Product product){

        var id = UUID.randomUUID().toString();
        product.setId(id);

        productRepository.save(product);

        return product;
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") String id){
        return productRepository.findById(id).orElse(null);
    }

}
