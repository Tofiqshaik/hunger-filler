package com.ty.foodapp.hungerfiller.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodapp.hungerfiller.dto.Product;
import com.ty.foodapp.hungerfiller.repository.ProductRepository;

@Repository
public class ProductDao {
	@Autowired
	ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product getProductById(int id) {
		Optional<Product> optional = productRepository.findById(id);
		return optional.get();
	}
	
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	public boolean deleteProductById(int id) {
		Product product = getProductById(id);
		if (product != null) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Product updateProductById(Product product) {
		return productRepository.save(product);
	}
}
