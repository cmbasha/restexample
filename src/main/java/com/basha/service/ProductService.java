package com.basha.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basha.entities.Product;
import com.basha.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public Iterable<Product> allProduct() {
		
		return  productRepository.findAll();
	}

	public Optional<Product> getProduct(int productNo) {
		return productRepository.findById(productNo);
	}

	public void deleteProduct(int productNo) {
		productRepository.deleteById(productNo);;
	}

	public Product updateProductPrice(int productNo, int newPrice) {
		Product updateProduct=productRepository.getOne(productNo);
		updateProduct.setPrice(newPrice);
		return productRepository.saveAndFlush(updateProduct);
	}
	
	
}
