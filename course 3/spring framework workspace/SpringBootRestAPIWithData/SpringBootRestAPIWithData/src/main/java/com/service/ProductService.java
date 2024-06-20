package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductDao;
import com.entity.Product;

@Service
public class ProductService {
	@Autowired
	ProductDao productDao;
	
	public String storeProduct(Product product) {
		
		//productDao.save(product);
		//return "Product stored";
		//productDao.existsById(product.getPid())
		
		Optional<Product>	result	= productDao.findById(product.getPid());
		if(result.isPresent()) {
			return "Product id must be unique";
		}else {
			productDao.save(product);
			return "Record stored";
		}
	}
	
	public List<Product> findAllProducts() {
		return productDao.findAll();
	}
	
	
	public String deleteProduct(int pid) {
				
		Optional<Product>	result	= productDao.findById(pid);
		if(result.isPresent()) {
			//Product p = result.get();
			productDao.deleteById(pid);	
			return "Product deleted successfully";
		}else {
			
			return "Product not present";
		}
	}
	
	public String updateProductPrice(Product product) {	// id and price (new price)
				
		Optional<Product>	result	= productDao.findById(product.getPid());
		if(result.isPresent()) {
			Product p = result.get();
			p.setPrice(product.getPrice());
			productDao.saveAndFlush(p);
			return "Product updated successfully";
		}else {
			return "Product not present";
		}
	}
	
	public String updateProductQty(Product product) {	// id and qty (new qty)
		
		Optional<Product>	result	= productDao.findById(product.getPid());
		if(result.isPresent()) {
			Product p = result.get();
			p.setQty(product.getQty());
			productDao.saveAndFlush(p);
			return "Product updated successfully";
		}else {
			return "Product not present";
		}
	}
}




