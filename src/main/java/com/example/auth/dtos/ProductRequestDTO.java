package com.example.auth.dtos;

import jakarta.validation.constraints.NotNull;

public class ProductRequestDTO {
	
	@NotNull
	private String name;
	
	@NotNull
	private double price;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
