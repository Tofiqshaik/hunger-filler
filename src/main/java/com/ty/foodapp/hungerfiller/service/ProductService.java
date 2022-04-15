package com.ty.foodapp.hungerfiller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.foodapp.hungerfiller.dao.ProductDao;
import com.ty.foodapp.hungerfiller.dto.Product;
import com.ty.foodapp.hungerfiller.exception.NoIdFoundException;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	
	public Product saveProduct(Product product) {
		return productDao.saveProduct(product);
	}
	
	public Product getProductById(int id) {
		Product product = productDao.getProductById(id);
		if (product == null) {
			throw new NoIdFoundException("given "+id+" does not exist");
		}
		return product;
	}
	
	public List<Product> getAllProducts(){
		return productDao.getAllProduct();
	}
	
	public boolean deleteProductById(int id) {
		return productDao.deleteProductById(id);
	}
	
	public Product updateProductById(int id, Product product) {
		Product extproduct = getProductById(id);
		if (extproduct != null) {
			return productDao.updateProductById(product);
		}
		return null;
	}
}
