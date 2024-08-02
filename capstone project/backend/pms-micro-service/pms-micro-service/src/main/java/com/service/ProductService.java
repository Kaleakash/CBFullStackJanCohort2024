package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public String addProduct(Product product) {
		productRepository.save(product);
		return "Product added successfully";
	}
	
	public List<Product> retrieveAllProduct() {
		return productRepository.findAll();
	}
	
	public String deleteProduct(int pid) {
		Optional<Product> result = productRepository.findById(pid);
		if(result.isPresent()) {
			productRepository.deleteById(pid);
			return "product details deleted successfully";
		}else {
			return "product not present";
		}
	}
	
	public String updateProductInfo(Product product) {
		Optional<Product> result = productRepository.findById(product.getPid());
		if(result.isPresent()) {
			Product p = result.get();
			p.setImageurl(product.getImageurl());
			p.setPrice(p.getPrice());
			p.setQty(product.getQty());
			productRepository.saveAndFlush(p);
			return "product details updated successfully";
		}else {
			return "product not present";
		}
	}
	
}
