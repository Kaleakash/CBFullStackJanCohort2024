package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

}
