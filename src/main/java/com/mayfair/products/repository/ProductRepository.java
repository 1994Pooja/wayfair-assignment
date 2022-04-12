package com.mayfair.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayfair.products.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
