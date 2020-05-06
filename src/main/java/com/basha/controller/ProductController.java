package com.basha.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.basha.entities.Product;
import com.basha.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product)
	{
		return productService.addProduct(product);
	}
	@GetMapping("/all")
	public Iterable<Product> allProduct()
	{
		return productService.allProduct();
	}
	@GetMapping("/get/{productNo}")
	public Optional<Product> getProduct(@PathVariable("productNo") int productNo)
	{
		return productService.getProduct(productNo);
	}
	@DeleteMapping("/delete/{productNo}")
	public void deleteProduct(@PathVariable("productNo") int productNo)
	{
		productService.deleteProduct(productNo);
	}
	@PutMapping("/update/{productNo}/{newPrice:.+}")
	public Product updateProductCost(@PathVariable("productNo") int productNo,@PathVariable("newPrice") int newPrice)
	{
		return productService.updateProductPrice(productNo,newPrice);
	}
}
