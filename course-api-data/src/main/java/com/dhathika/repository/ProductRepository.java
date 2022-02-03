package com.dhathika.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhathika.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    public Product findByproductNameIgnoreCase(String productName);
}
