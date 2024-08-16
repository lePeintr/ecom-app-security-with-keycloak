package com.example.inventory_service.web;

import com.example.inventory_service.entities.Product;
import com.example.inventory_service.repositories.IProductRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Cette classe ProductRestController représente ...
 *
 * @author Utilisateur
 * @version 1.0
 */
@RestController
@RequestMapping("/api")
public class ProductRestController {

    private IProductRepository productRepository;

    public ProductRestController(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getAllProduct(@PathVariable String id){
        return productRepository.findById(id).get();
    }

    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }
}
