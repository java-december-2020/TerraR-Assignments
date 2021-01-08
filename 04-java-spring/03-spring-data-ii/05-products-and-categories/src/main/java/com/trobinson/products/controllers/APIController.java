package com.trobinson.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trobinson.products.models.Product;
import com.trobinson.products.services.ProductService;

@RestController
public class APIController {

	
	@Autowired
	private ProductService pService;
	
	
	@GetMapping("/pTest")
	public List<Product> pTest() {
		return pService.findAllProducts();
	}
}
