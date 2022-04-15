package com.ty.foodapp.hungerfiller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodapp.hungerfiller.dao.ProductDao;
import com.ty.foodapp.hungerfiller.dto.Product;
import com.ty.foodapp.hungerfiller.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	@ApiOperation(value = " SAVE Product DETAILS ", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "given user data SAVED  successFully "),
			@ApiResponse(code = 405, message = "No given Id found") })

	
	@PostMapping("/product")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@ApiOperation(value = " GET PRODUCT  DETAILS BY ID", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "PRODUCT GETBY ID successFully By Id"),
			@ApiResponse(code = 405, message = "No given Id found") })

	
	@GetMapping("/product")
	public Product getProductById(@RequestParam int id) {
		return productService.getProductById(id);
	}
	@ApiOperation(value = " GET ALL PRODUCT BYID", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "GET ALL PRODUCT  successFully By Id"),
			@ApiResponse(code = 405, message = "No given Id found") })

	
	@GetMapping("/allproduct")
	public List<Product> getAllProduct(){
		return productService.getAllProducts();
	}
	@ApiOperation(value = " DELETE PRODUCT DETAILS BY ID", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "given PRODUCT data deleted successFully By Id"),
			@ApiResponse(code = 405, message = "No given Id found") })

	
	@DeleteMapping("/product")
	public boolean deleteProductById(@RequestParam int id) {
		return productService.deleteProductById(id);
	}
	@ApiOperation(value = " UPDATE PRODUCT DETAILS BY ID", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "given PRODUCT data UPDATED successFully By Id"),
			@ApiResponse(code = 405, message = "No given Id found") })

	
	@PatchMapping("/product")
	public Product updateProductById(@RequestParam int id, @RequestBody Product product) {
		return productService.updateProductById(id, product);
	}
}
