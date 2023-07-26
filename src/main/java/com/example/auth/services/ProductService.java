package com.example.auth.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auth.entities.Product;
import com.example.auth.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void save(Product product) {
		
		productRepository.save(product);
	}
	
	public List<Product> findAll() {
		
		return productRepository.findAll();
	}
}
