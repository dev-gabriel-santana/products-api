package com.example.produtosapi.controller;

import com.example.produtosapi.model.Product;
import com.example.produtosapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id){
        productRepository.deleteById(id);
        return "Produto " + id +  " removido com sucesso!";
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable("id") String id,
            @RequestBody Product product
    ) {
        product.setId(id);
        productRepository.save(product);
    }

    @GetMapping
    public List<Product> search(@RequestParam("name") String name){
        return productRepository.findByNameContaining(name);
    }
}
