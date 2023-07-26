package com.example.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auth.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
