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
	
}




