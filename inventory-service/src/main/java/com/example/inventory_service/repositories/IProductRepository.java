package com.example.inventory_service.repositories;

import com.example.inventory_service.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Cette classe IProductRepository représente ...
 *
 * @author Utilisateur
 * @version 1.0
 */
public interface IProductRepository extends JpaRepository<Product,String> {
}
