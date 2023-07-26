package com.example.auth.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.dtos.ProductRequestDTO;
import com.example.auth.entities.Product;
import com.example.auth.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity postProduct(@RequestBody @Valid ProductRequestDTO body) {
		
		Product newProduct = new Product(body);
		
		this.productService.save(newProduct);
		
		return ResponseEntity.ok().build();
	}
	
	
	@GetMapping
	public ResponseEntity getAllProduct() {
		
		List<Product> productList = this.productService.findAll();
		
		return ResponseEntity.ok(productList);
	}
}
